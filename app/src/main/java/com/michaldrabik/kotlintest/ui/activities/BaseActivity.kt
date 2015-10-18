package com.michaldrabik.kotlintest.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.michaldrabik.kotlintest.R
import org.jetbrains.anko.find

public abstract class BaseActivity : AppCompatActivity() {

  protected abstract fun getLayoutResId(): Int

  protected abstract fun getActivityTitle(): String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutResId())
    setupToolbar()
  }

  private fun setupToolbar() {
    find<TextView>(R.id.toolbarTitle).text = getActivityTitle()
  }

}