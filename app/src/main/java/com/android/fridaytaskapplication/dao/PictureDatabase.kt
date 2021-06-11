package com.android.fridaytaskapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.fridaytaskapplication.model.Picture

@Database(entities = [Picture::class], version = 1, exportSchema = false)
abstract class PictureDatabase : RoomDatabase() {
    abstract fun userDao(): PictureDAO

    companion object {
        @Volatile
        private var INSTANCE: PictureDatabase? = null

        fun getDatabase(context: Context): PictureDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PictureDatabase::class.java, "user_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}