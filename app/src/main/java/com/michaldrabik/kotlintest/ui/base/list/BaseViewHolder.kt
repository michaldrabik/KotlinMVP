package com.michaldrabik.kotlintest.ui.base.list

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

abstract class BaseViewHolder<T : Parcelable> : RelativeLayout {

  constructor(context: Context) : super(context) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    init()
  }

  private fun init() {
    View.inflate(context, layoutResId(), this)
  }

  protected abstract fun layoutResId(): Int

  abstract fun bind(item: T)

}
