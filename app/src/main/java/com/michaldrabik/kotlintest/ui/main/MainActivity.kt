package com.michaldrabik.kotlintest.ui.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.widget.Toast
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.BaseActivity
import com.michaldrabik.kotlintest.ui.main.list.MainAdapter
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

  override fun onDestroy() {
    presenter.destroy()
    super.onDestroy()
  }

  private fun setupToolbar() {
    toolbarTitle.text = getString(R.string.chuck_norris_jokes)
  }

  private fun setupRecycler() {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL).apply {
      setDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.divider)!!)
    }
    recyclerView.addItemDecoration(divider)
    recyclerView.adapter = adapter
  }

  private fun setupSwipeToRefresh() {
    swipeRefreshLayout.setOnRefreshListener { presenter.fetchJokes() }
  }

  override fun showJokes(jokes: List<Joke>) {
    adapter.clearItems()
    adapter.addItems(jokes)
    swipeRefreshLayout.isRefreshing = false
    statusText.visibility = GONE
  }

  override fun showError(error: Throwable) {
    swipeRefreshLayout.isRefreshing = false
    Toast.makeText(this, "Error. ${error.message.toString()}", Toast.LENGTH_LONG).show()
  }
}
