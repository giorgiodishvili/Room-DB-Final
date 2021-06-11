package com.android.fridaytaskapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.fridaytaskapplication.model.Picture


@Dao
interface PictureDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPicture(picture: Picture)

    @Query("SELECT * FROM picture ORDER BY id ASC")
    fun readAllData(): LiveData<List<Picture>>

    @Update
    fun updatePicture(user: Picture?)

    @Delete
    fun deletePicture(user: Picture?)
}