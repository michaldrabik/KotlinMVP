package com.michaldrabik.kotlintest

import android.app.Application
import android.content.Context
import timber.log.Timber

class JokesApp : Application() {

  companion object {
    fun get(context: Context): JokesApp = context.applicationContext as JokesApp
  }

  override fun onCreate() {
    super.onCreate()
    setupTimber()
  }

  private fun setupTimber() {
    Timber.plant(Timber.DebugTree())
  }

}
