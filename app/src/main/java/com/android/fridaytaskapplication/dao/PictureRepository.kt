package com.android.fridaytaskapplication.dao

import androidx.lifecycle.LiveData
import com.android.fridaytaskapplication.model.Picture

class PictureRepository(private val pictureDAO: PictureDAO) {
    val readAllData: LiveData<List<Picture>> = pictureDAO.readAllData()

    suspend fun addPicture(picture: Picture) {
        pictureDAO.addPicture(picture)
    }

    suspend fun updatePicture(picture: Picture) {
        pictureDAO.updatePicture(picture)
    }

    suspend fun deletePicture(picture: Picture) {
        pictureDAO.deletePicture(picture)
    }
}