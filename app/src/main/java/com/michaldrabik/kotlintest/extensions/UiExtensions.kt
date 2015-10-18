package com.michaldrabik.kotlintest.extensions

import android.content.Context
import android.view.View

fun Int.dpToPx(context: Context) = this * context.resources.displayMetrics.density

fun View.show() {
  this.visibility = View.VISIBLE
}

fun View.hide() {
  this.visibility = View.GONE
}