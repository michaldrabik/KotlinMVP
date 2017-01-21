package com.michaldrabik.kotlintest

import android.app.Application
import com.michaldrabik.kotlintest.injection.component.AppComponent
import com.michaldrabik.kotlintest.injection.component.DaggerAppComponent

class App : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    setupComponent()
  }

  private fun setupComponent() {
    appComponent = DaggerAppComponent.builder().build()
  }
}
