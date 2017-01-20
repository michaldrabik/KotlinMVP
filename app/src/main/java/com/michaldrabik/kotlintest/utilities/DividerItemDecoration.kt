package com.michaldrabik.kotlintest.utilities

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class DividerItemDecoration(context: Context, orientation: Int, marginPx: Int) : RecyclerView.ItemDecoration() {

  private val mDivider: Drawable
  private var mOrientation: Int = 0
  private val margin = marginPx

  init {
    val a = context.obtainStyledAttributes(ATTRS)
    mDivider = a.getDrawable(0)
    a.recycle()
    setOrientation(orientation)
  }

  fun setOrientation(orientation: Int) {
    if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
      throw IllegalArgumentException("Invalid orientation")
    }
    mOrientation = orientation
  }

  override fun onDraw(c: Canvas, parent: RecyclerView) {
    if (mOrientation == VERTICAL_LIST) {
      drawVertical(c, parent)
    } else {
      drawHorizontal(c, parent)
    }
  }

  fun drawVertical(c: Canvas, parent: RecyclerView) {
    val left = parent.paddingLeft + margin
    val right = (parent.width - parent.paddingRight) - margin

    val childCount = parent.childCount
    for (i in 0..childCount - 1) {
      val child = parent.getChildAt(i)
      val params = child.layoutParams as RecyclerView.LayoutParams
      val top = child.bottom + params.bottomMargin
      val bottom = top + mDivider.intrinsicHeight
      mDivider.setBounds(left, top, right, bottom)
      mDivider.draw(c)
    }
  }

  fun drawHorizontal(c: Canvas, parent: RecyclerView) {
    val top = parent.paddingTop
    val bottom = parent.height - parent.paddingBottom

    val childCount = parent.childCount
    for (i in 0..childCount - 1) {
      val child = parent.getChildAt(i)
      val params = child.layoutParams as RecyclerView.LayoutParams
      val left = child.right + params.rightMargin
      val right = left + mDivider.intrinsicHeight
      mDivider.setBounds(left, top, right, bottom)
      mDivider.draw(c)
    }
  }

  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
    if (mOrientation == VERTICAL_LIST) {
      outRect.set(0, 0, 0, mDivider.intrinsicHeight)
    } else {
      outRect.set(0, 0, mDivider.intrinsicWidth, 0)
    }
  }

  companion object {

    private val ATTRS = intArrayOf(R.attr.listDivider)
    val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
    val VERTICAL_LIST = LinearLayoutManager.VERTICAL
  }

}