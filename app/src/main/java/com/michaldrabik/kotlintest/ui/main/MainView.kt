package com.michaldrabik.kotlintest.ui.main

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.MvpView

interface MainView : MvpView {

  fun showJokes(jokes: List<Joke>)

  fun showError(error: Throwable)

}