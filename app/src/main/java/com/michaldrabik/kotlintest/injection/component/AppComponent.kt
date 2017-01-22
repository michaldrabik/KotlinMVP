package com.michaldrabik.kotlintest.injection.component

import com.michaldrabik.kotlintest.injection.module.Bindings
import com.michaldrabik.kotlintest.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(Bindings::class, NetworkModule::class))
interface AppComponent {

  fun activityComponent(): ActivityComponent

}