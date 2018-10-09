package com.michaldrabik.kotlintest.utilities

import android.content.Context
import com.michaldrabik.kotlintest.App
import com.michaldrabik.kotlintest.injection.component.AppComponent

fun Context.getAppComponent(): AppComponent = (applicationContext as App).appComponent
