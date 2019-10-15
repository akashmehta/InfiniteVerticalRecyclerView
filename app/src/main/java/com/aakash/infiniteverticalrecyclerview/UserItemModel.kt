package com.aakash.infiniteverticalrecyclerview

import android.graphics.drawable.Drawable

data class UserItemModel (
    var position: Int = 0,
    var runnable: Runnable ?= null,
    var imageList: List<Drawable?>
)