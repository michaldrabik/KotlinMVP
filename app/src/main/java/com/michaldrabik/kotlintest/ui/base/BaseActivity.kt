package com.michaldrabik.kotlintest.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.michaldrabik.kotlintest.R

abstract class BaseActivity : AppCompatActivity() {

  protected abstract fun getLayoutResId(): Int

  protected abstract fun getActivityTitle(): String

  private val toolbarTitle by lazy { findViewById(R.id.toolbarTitle) as TextView }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutResId())
    setupToolbar()
  }

  private fun setupToolbar() {
    toolbarTitle.text = getActivityTitle()
  }

}