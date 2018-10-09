package com.michaldrabik.kotlintest.injection.component

import com.michaldrabik.kotlintest.injection.module.BindingsModule
import com.michaldrabik.kotlintest.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BindingsModule::class, NetworkModule::class])
interface AppComponent {

  fun activityComponent(): ActivityComponent

}