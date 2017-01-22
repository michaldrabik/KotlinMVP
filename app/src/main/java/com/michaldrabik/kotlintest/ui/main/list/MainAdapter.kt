package com.michaldrabik.kotlintest.ui.main.list

import android.content.Context
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.injection.scope.PerActivity
import com.michaldrabik.kotlintest.ui.base.list.BaseListAdapter
import com.michaldrabik.kotlintest.ui.base.list.BaseViewHolder
import javax.inject.Inject

@PerActivity
class MainAdapter @Inject constructor() : BaseListAdapter<Joke>() {

  override fun getListItemView(context: Context): BaseViewHolder<Joke> {
    return JokeViewHolder(context)
  }

}