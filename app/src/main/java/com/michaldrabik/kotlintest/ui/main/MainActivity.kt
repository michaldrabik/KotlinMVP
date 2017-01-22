package com.michaldrabik.kotlintest.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.BaseActivity
import com.michaldrabik.kotlintest.ui.main.list.MainAdapter
import com.michaldrabik.kotlintest.utilities.DividerItemDecoration
import com.michaldrabik.kotlintest.utilities.extensions.dpToPx
import com.michaldrabik.kotlintest.utilities.extensions.hide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

open class MainActivity : BaseActivity(), MainView {

  @Inject lateinit var presenter: MainPresenter
  @Inject lateinit var adapter: MainAdapter

  override fun getLayoutResId() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent?.inject(this)

    setupToolbar()
    setupRecycler()
    setupSwipeToRefresh()

    presenter.bind(this)
  }

  private fun setupToolbar() {
    toolbarTitle.text = getString(R.string.chuck_norris_jokes)
  }

  private fun setupRecycler() {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 8.dpToPx(this)))
    recyclerView.adapter = adapter
  }

  private fun setupSwipeToRefresh() {
    swipeRefreshLayout.setOnRefreshListener { presenter.fetchJokes() }
  }

  override fun onFetchJokesSuccess(jokes: List<Joke>) {
    adapter.clearItems()
    adapter.addItems(jokes)
    swipeRefreshLayout.isRefreshing = false
    statusText.hide()
  }

  override fun onFetchJokesError(error: Throwable) {
    Toast.makeText(this, "Error. ${error.message.toString()}", Toast.LENGTH_LONG).show()
    swipeRefreshLayout.isRefreshing = false
  }

  override fun onDestroy() {
    presenter.destroy()
    super.onDestroy()
  }

}
