package com.michaldrabik.kotlintest.ui.main

import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.ui.base.BasePresenter

class MainPresenter : BasePresenter<MainView>() {

  fun fetchJokes() {
    disposables.add(
        jokesApi.fetchRandomJokes().subscribe(
            { onFetchJokesSuccess(it.value) },
            { onFetchJokesError(it) }
        )
    )
  }

  fun onFetchJokesSuccess(jokes: List<Joke>) {
    view?.onFetchJokesSuccess(jokes)
  }

  fun onFetchJokesError(error: Throwable) {
    view?.onFetchJokesError(error)
  }

}
