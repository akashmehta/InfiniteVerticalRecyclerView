package com.aakash.infiniteverticalrecyclerview

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserListRecyclerAdapter(private val itemList: List<UserItemModel>) :
    RecyclerView.Adapter<UserListRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    private val userHandler = Handler()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_user_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: UserItemModel = itemList[position]
        holder.view.apply {
            rvContent.layoutManager = LinearLayoutManager(context)
            rvContent.adapter = ScrollingImageRecyclerAdapter(item.imageList)
            item.runnable ?: let {
                item.runnable = Runnable {
                    rvContent.scrollBy(0, 100)
                    item.position++
                    if (item.position < 30) {
                        userHandler.postDelayed(item.runnable, 50)
                    }
                }
                userHandler.postDelayed(item.runnable, 50)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}