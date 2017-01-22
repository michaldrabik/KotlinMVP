package com.michaldrabik.kotlintest.utilities.extensions

import android.content.Context
import android.view.View

fun Int.dpToPx(context: Context): Int = this * context.resources.displayMetrics.density.toInt()

fun View.show() {
  this.visibility = View.VISIBLE
}

fun View.hide() {
  this.visibility = View.GONE
}


