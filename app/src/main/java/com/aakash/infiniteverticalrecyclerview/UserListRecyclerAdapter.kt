package com.aakash.infiniteverticalrecyclerview

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class UserListRecyclerAdapter(private val itemList: List<List<Drawable>>) :
    RecyclerView.Adapter<UserListRecyclerAdapter.ViewHolder>() {

    private val TAG = UserListRecyclerAdapter::class.java.simpleName

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_user_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: List<Drawable> = itemList[position]
        holder.view.apply {
        }
    }

    override fun getItemCount(): Int = itemList.size
}