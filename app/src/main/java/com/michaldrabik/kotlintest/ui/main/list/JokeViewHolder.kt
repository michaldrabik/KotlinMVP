package com.michaldrabik.kotlintest.ui.main.list

import android.content.Context
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.list.BaseViewHolder
import kotlinx.android.synthetic.main.view_joke.view.*

class JokeViewHolder(context: Context) : BaseViewHolder<Joke>(context) {

  override fun layoutResId(): Int = R.layout.view_joke

  override fun bind(item: Joke) {
    idText.text = "#${item.id}"
    jokeText.text = item.joke
  }

}
