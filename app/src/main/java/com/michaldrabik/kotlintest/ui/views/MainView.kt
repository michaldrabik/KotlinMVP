package com.michaldrabik.kotlintest.ui.views

import com.michaldrabik.kotlintest.data.models.Joke

interface MainView : PresentationView {
  fun onFetchJokesSuccess(jokes: List<Joke>)
  fun onFetchJokesError(error: Throwable)
}