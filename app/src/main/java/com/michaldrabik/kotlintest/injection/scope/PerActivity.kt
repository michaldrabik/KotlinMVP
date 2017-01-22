package com.michaldrabik.kotlintest.injection.scope

import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity