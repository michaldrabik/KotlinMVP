package com.michaldrabik.kotlintest.ui.activities.presenters

import com.michaldrabik.kotlintest.ui.activities.BaseActivity
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class BasePresenter<T : BaseActivity>() {

  protected val compositeSubscription = CompositeSubscription()
  protected var activity: T? = null

  fun bind(t: T) {
    activity = t
  }

  fun unbind() {
    activity = null
  }

  protected fun addSubscription(subscription: Subscription) {
    compositeSubscription.add(subscription)
  }

  fun onDestroy() {
    compositeSubscription.clear()
    unbind()
  }

}