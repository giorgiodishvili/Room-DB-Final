package com.android.fridaytaskapplication.callback

import com.android.fridaytaskapplication.model.Picture

interface RecyclerViewCallback {
    fun onUpdateClick(picture: Picture)
    fun onDeleteClick(picture: Picture)
}