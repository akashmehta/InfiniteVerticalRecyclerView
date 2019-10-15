package com.aakash.infiniteverticalrecyclerview

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemList = ArrayList<UserItemModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repeat((0 until 4).count()) {
            val imageList = ArrayList<Drawable?>()
            imageList.add(ContextCompat.getDrawable(this, R.drawable.image1))
            imageList.add(ContextCompat.getDrawable(this, R.drawable.image2))
            imageList.add(ContextCompat.getDrawable(this, R.drawable.image3))
            imageList.add(ContextCompat.getDrawable(this, R.drawable.image4))
            imageList.add(ContextCompat.getDrawable(this, R.drawable.image5))
            itemList.add(UserItemModel(imageList = imageList))
        }


        rvContent.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        rvContent.adapter = UserListRecyclerAdapter(itemList)
    }
}
