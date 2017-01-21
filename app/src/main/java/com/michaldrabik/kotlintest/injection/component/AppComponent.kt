package com.michaldrabik.kotlintest.injection.component

import com.michaldrabik.kotlintest.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface AppComponent {

}