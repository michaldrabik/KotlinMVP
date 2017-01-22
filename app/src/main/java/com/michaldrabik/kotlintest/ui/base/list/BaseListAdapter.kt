package com.michaldrabik.kotlintest.ui.base.list

import android.content.Context
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

abstract class BaseListAdapter<T : Parcelable> : RecyclerView.Adapter<BaseListAdapter<T>.ViewHolder>() {

  protected var items: MutableList<T> = ArrayList()

  abstract fun getListItemView(context: Context): BaseViewHolder<T>

  fun clearItems() {
    val itemCount = items.size
    items.clear()
    notifyItemRangeRemoved(0, itemCount)
  }

  fun addItems(itemsToAdd: List<T>) {
    items.addAll(itemsToAdd)
    notifyItemRangeInserted(0, itemsToAdd.size)
  }

  override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder = ViewHolder(getListItemView(viewGroup.context))

  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.view.bind(items[position])

  override fun getItemCount(): Int = items.size

  inner class ViewHolder(var view: BaseViewHolder<T>) : RecyclerView.ViewHolder(view)

}
