package com.michaldrabik.kotlintest.data

import io.reactivex.Observer

abstract class SimpleObserver<T> : Observer<T> {
  override fun onNext(response: T) {
  }

  override fun onError(error: Throwable) {
  }

  override fun onComplete() {
  }
}
