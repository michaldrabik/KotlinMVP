package com.michaldrabik.kotlintest.ui.views.presenters

import com.michaldrabik.kotlintest.data.SimpleObserver
import com.michaldrabik.kotlintest.data.api.Api
import com.michaldrabik.kotlintest.data.api.JokesApi
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.data.models.Response
import com.michaldrabik.kotlintest.ui.views.MainView
import com.michaldrabik.kotlintest.ui.views.MainActivity

class MainPresenter() : BasePresenter<MainView>() {

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
    view?.onFetchJokesSuccess(jokes)
  }

  fun onFetchJokesError(error: Throwable) {
    view?.onFetchJokesError(error)
  }

}
