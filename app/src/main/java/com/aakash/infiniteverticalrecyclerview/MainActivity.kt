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

    private val imageList = ArrayList<Drawable?>()
    private val handler = Handler()
    private var runnable: Runnable? = null
    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList.add(ContextCompat.getDrawable(this, R.drawable.image1))
        imageList.add(ContextCompat.getDrawable(this, R.drawable.image2))
        imageList.add(ContextCompat.getDrawable(this, R.drawable.image3))
        imageList.add(ContextCompat.getDrawable(this, R.drawable.image4))
        imageList.add(ContextCompat.getDrawable(this, R.drawable.image5))

        rvContent.layoutManager = LinearLayoutManager(this)
        rvContent.adapter = ScrollingImageRecyclerAdapter(imageList)
        runnable = Runnable {
            rvContent.scrollBy(0, 100)
            position++
            if (position < 30) {
                handler.postDelayed(runnable, 50)
            }
        }
        handler.postDelayed(runnable, 50)
    }
}
