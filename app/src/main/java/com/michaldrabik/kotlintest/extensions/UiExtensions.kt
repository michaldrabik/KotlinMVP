package com.michaldrabik.kotlintest.extensions

import android.content.Context
import android.view.View
import com.michaldrabik.kotlintest.data.api.JokesApi
import com.michaldrabik.kotlintest.ui.views.PresenterView
import com.michaldrabik.kotlintest.ui.views.presenters.BasePresenter
import com.michaldrabik.kotlintest.ui.views.presenters.MainPresenter

fun Int.dpToPx(context: Context) = this * context.resources.displayMetrics.density

fun View.show() {
  this.visibility = View.VISIBLE
}

fun View.hide() {
  this.visibility = View.GONE
}
