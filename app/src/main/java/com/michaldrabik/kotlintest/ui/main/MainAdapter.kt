package com.michaldrabik.kotlintest.ui.main

import android.content.Context
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.ui.base.BaseListAdapter
import com.michaldrabik.kotlintest.ui.base.BaseViewHolder

class MainAdapter : BaseListAdapter<Joke>() {

  override fun getListItemView(context: Context): BaseViewHolder<Joke> {
    return JokeViewHolder(context)
  }

}