package com.michaldrabik.kotlintest.ui.activities

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.extensions.dpToPx
import com.michaldrabik.kotlintest.extensions.hide
import com.michaldrabik.kotlintest.extensions.show
import com.michaldrabik.kotlintest.ui.DividerItemDecoration
import com.michaldrabik.kotlintest.ui.activities.presenters.MainPresenter
import com.michaldrabik.kotlintest.ui.adapters.MainAdapter
import kotlinx.android.synthetic.activity_main.progressBar
import kotlinx.android.synthetic.activity_main.recyclerView
import kotlinx.android.synthetic.activity_main.swipeRefreshLayout
import org.jetbrains.anko.toast

open class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

  val adapter = MainAdapter()
  val presenter = MainPresenter()

  override fun getLayoutResId() = R.layout.activity_main;

  override fun getActivityTitle(): String = getString(R.string.chuck_norris_jokes)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.bind(this)
    setupRecycler()
    setupSwipeToRefresh()
    fetchJokes()
  }

  private fun setupRecycler() {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 8.dpToPx(this).toInt()))
    recyclerView.adapter = adapter
  }

  private fun setupSwipeToRefresh() {
    swipeRefreshLayout.setOnRefreshListener(this)
  }

  private fun fetchJokes() {
    presenter.fetchJokes()
    progressBar.show()
  }

  open fun onFetchJokesSuccess(jokes: List<Joke>) {
    adapter.clearItems()
    adapter.addItems(jokes)
    progressBar.hide()
    swipeRefreshLayout.isRefreshing = false;
  }

  open fun onFetchJokesError(error: Throwable) {
    toast(getString(R.string.something_went_wrong_error) + error.getMessage())
    progressBar.hide()
    swipeRefreshLayout.isRefreshing = false;
  }

  override fun onRefresh() {
    presenter.fetchJokes()
  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }

}
