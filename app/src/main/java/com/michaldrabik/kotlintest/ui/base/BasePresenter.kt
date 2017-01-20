package com.michaldrabik.kotlintest.ui.base

import com.michaldrabik.kotlintest.data.api.Api
import com.michaldrabik.kotlintest.data.api.JokesApi
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : MvpView> {

  var jokesApi: Api = JokesApi
  protected val disposables = CompositeDisposable()
  protected var view: T? = null

  fun bind(view: T) {
    this.view = view
  }

  fun unbind() {
    this.view = null
  }

  fun onDestroy() {
    disposables.clear()
    unbind()
  }

}