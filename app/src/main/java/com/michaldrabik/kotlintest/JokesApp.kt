package com.michaldrabik.kotlintest

import android.app.Application
import android.content.Context

class JokesApp : Application() {

  companion object {
    fun get(context: Context): JokesApp = context.applicationContext as JokesApp
  }

}
