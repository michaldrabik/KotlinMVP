package com.michaldrabik.kotlintest.injection.module

import com.michaldrabik.kotlintest.data.DataManager
import com.michaldrabik.kotlintest.data.DataManagerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class Bindings {

  @Binds
  internal abstract fun bindDataManger(manager: DataManagerImpl): DataManager

}