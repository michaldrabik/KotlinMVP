package com.michaldrabik.kotlintest.ui.viewholders

import android.content.Context
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.models.Joke
import kotlinx.android.synthetic.main.viewholder_joke.view.*

class JokeViewHolder(context: Context) : BaseViewHolder<Joke>(context) {

  override fun layoutResId(): Int = R.layout.viewholder_joke

  override fun setData(item: Joke) {
    idText.text = item.id.toString()
    jokeText.text = item.joke
  }

}
