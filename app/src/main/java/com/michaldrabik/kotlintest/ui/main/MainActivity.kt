package com.michaldrabik.kotlintest.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.BaseActivity
import com.michaldrabik.kotlintest.ui.main.list.MainAdapter
import com.michaldrabik.kotlintest.utilities.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

open class MainActivity : BaseActivity(), MainView {

  @Inject lateinit var presenter: MainPresenter
  @Inject lateinit var adapter: MainAdapter

  override fun getLayoutResId() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getAppComponent().inject(this)

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
    recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 8.dpToPx(this).toInt()))
    recyclerView.adapter = adapter
  }

  private fun setupSwipeToRefresh() {
    swipeRefreshLayout.setOnRefreshListener { presenter.fetchJokes() }
  }

  private fun fetchJokes() {
    presenter.fetchJokes()
    progressBar.show()
  }

  override fun onFetchJokesSuccess(jokes: List<Joke>) {
    adapter.clearItems()
    adapter.addItems(jokes)
    progressBar.hide()
    swipeRefreshLayout.isRefreshing = false
  }

  override fun onFetchJokesError(error: Throwable) {
    Toast.makeText(this, "Error. ${error.message.toString()}", Toast.LENGTH_LONG).show()
    progressBar.hide()
    swipeRefreshLayout.isRefreshing = false
  }

  override fun onDestroy() {
    presenter.destroy()
    super.onDestroy()
  }

}
