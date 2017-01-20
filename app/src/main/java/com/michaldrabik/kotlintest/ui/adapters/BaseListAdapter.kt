package com.michaldrabik.kotlintest.ui.adapters

import android.content.Context
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.michaldrabik.kotlintest.ui.viewholders.BaseViewHolder
import java.util.*

abstract class BaseListAdapter<T : Parcelable> : RecyclerView.Adapter<BaseListAdapter<T>.ViewHolder>() {

  abstract fun getListItemView(context: Context): BaseViewHolder<T>

  protected var items: MutableList<T> = ArrayList()

  fun clearItems() {
    val itemCount = items.size
    items.clear()
    notifyItemRangeRemoved(0, itemCount)
  }

  fun addItems(itemsToAdd: List<T>) {
    items.addAll(itemsToAdd)
    notifyItemRangeInserted(0, itemsToAdd.size)
  }

  override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
    return ViewHolder(getListItemView(viewGroup.context))
  }

  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.view.setData(items[position])
  }

  override fun getItemCount(): Int {
    return items.size
  }

  inner class ViewHolder(var view: BaseViewHolder<T>) : RecyclerView.ViewHolder(view)

}
