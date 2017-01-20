package com.michaldrabik.kotlintest.ui.main

import android.content.Context
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.view_joke.view.*

class JokeViewHolder(context: Context) : BaseViewHolder<Joke>(context) {

  override fun layoutResId(): Int = R.layout.view_joke

  override fun setData(item: Joke) {
    idText.text = item.id.toString()
    jokeText.text = item.joke
  }

}
