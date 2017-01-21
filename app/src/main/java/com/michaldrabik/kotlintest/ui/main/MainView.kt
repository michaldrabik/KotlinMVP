package com.michaldrabik.kotlintest.ui.main

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.MvpView

interface MainView : MvpView {

  fun onFetchJokesSuccess(jokes: List<Joke>)

  fun onFetchJokesError(error: Throwable)

}