package com.aakash.infiniteverticalrecyclerview

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ScrollingImageRecyclerAdapter(private val itemList: List<Drawable?>) :
    RecyclerView.Adapter<ScrollingImageRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_scrollable_image, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            (view as ImageView).setImageDrawable(itemList[position % itemList.size])
        }
    }

    override fun getItemCount(): Int = Integer.MAX_VALUE
}