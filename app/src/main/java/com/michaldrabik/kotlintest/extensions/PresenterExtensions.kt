package com.michaldrabik.kotlintest.extensions

import com.michaldrabik.kotlintest.data.api.JokesApi
import com.michaldrabik.kotlintest.ui.views.presenters.MainPresenter

fun jokesApi(): JokesApi {
  return JokesApi
}