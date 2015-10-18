package com.michaldrabik.kotlintest.ui.adapters

import android.content.Context
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.ui.viewholders.BaseViewHolder
import com.michaldrabik.kotlintest.ui.viewholders.JokeViewHolder

public class MainAdapter() : BaseListAdapter<Joke>() {

  override fun getListItemView(context: Context): BaseViewHolder<Joke> {
    return JokeViewHolder(context);
  }

}