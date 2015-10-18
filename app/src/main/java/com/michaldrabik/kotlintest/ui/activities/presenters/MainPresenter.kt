package com.michaldrabik.kotlintest.ui.activities.presenters

import com.michaldrabik.kotlintest.data.SimpleObserver
import com.michaldrabik.kotlintest.data.api.Api
import com.michaldrabik.kotlintest.data.api.JokesApi
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.data.models.Response
import com.michaldrabik.kotlintest.ui.activities.MainActivity

class MainPresenter() : BasePresenter<MainActivity>() {

  var api: Api = JokesApi()

  fun fetchJokes() {
    addSubscription(api.fetchRandomJokes().subscribe(object : SimpleObserver<Response<Joke>>() {
      override fun onNext(response: Response<Joke>) {
        onFetchJokesSuccess(response.value)
      }

      override fun onError(error: Throwable) {
        onFetchJokesError(error)
      }
    }))
  }

  fun onFetchJokesSuccess(jokes: List<Joke>) {
    activity?.onFetchJokesSuccess(jokes)
  }

  fun onFetchJokesError(error: Throwable) {
    activity?.onFetchJokesError(error)
  }

}
