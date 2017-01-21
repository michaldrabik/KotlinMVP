package com.michaldrabik.kotlintest.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  protected abstract fun getLayoutResId(): Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutResId())
  }

}