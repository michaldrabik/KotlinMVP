package com.michaldrabik.kotlintest.ui.base.list

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

abstract class BaseViewHolder<T> @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

  init {
    inflate()
  }

  private fun inflate() {
    View.inflate(context, layoutResId(), this)
  }

  protected abstract fun layoutResId(): Int

  abstract fun bind(item: T)

}
