package com.michaldrabik.kotlintest.ui.views.presenters

import com.michaldrabik.kotlintest.data.SimpleObserver
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.data.models.Response
import com.michaldrabik.kotlintest.ui.views.MainView

class MainPresenter() : BasePresenter<MainView>() {

  fun fetchJokes() {
    addSubscription(jokesApi.fetchRandomJokes().subscribe(object : SimpleObserver<Response<Joke>>() {
      override fun onNext(response: Response<Joke>) {
        onFetchJokesSuccess(response.value)
      }

      override fun onError(error: Throwable) {
        onFetchJokesError(error)
      }
    }))
  }

  fun onFetchJokesSuccess(jokes: List<Joke>) {
    view?.onFetchJokesSuccess(jokes)
  }

  fun onFetchJokesError(error: Throwable) {
    view?.onFetchJokesError(error)
  }

}
