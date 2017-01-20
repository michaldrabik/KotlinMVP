package com.michaldrabik.kotlintest

import android.app.Application
import android.content.Context

class App : Application() {

  companion object {
    fun get(context: Context): App = context.applicationContext as App
  }

}
