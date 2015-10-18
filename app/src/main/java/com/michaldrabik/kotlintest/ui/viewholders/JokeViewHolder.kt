package com.michaldrabik.kotlintest.ui.viewholders

import android.content.Context
import com.michaldrabik.kotlintest.R
import com.michaldrabik.kotlintest.data.models.Joke
import kotlinx.android.synthetic.viewholder_joke.view.idText
import kotlinx.android.synthetic.viewholder_joke.view.jokeText

public class JokeViewHolder(context: Context) : BaseViewHolder<Joke>(context) {

  override fun layoutResId(): Int {
    return R.layout.viewholder_joke
  }

  override fun setData(item: Joke) {
    idText.text = "${item.id}"
    jokeText.text = "${item.joke}"
  }

}
