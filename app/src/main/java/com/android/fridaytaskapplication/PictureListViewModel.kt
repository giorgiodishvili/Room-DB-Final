package com.android.fridaytaskapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.fridaytaskapplication.dao.PictureDatabase
import com.android.fridaytaskapplication.dao.PictureRepository
import com.android.fridaytaskapplication.model.Picture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PictureListViewModel : ViewModel() {

    lateinit var readAllData: LiveData<List<Picture>>

    private lateinit var repository: PictureRepository

    fun init() {
        val userDao = PictureDatabase.getDatabase(App.applicationContext()).userDao()
        repository = PictureRepository(userDao)
    }

    fun readData(){
        readAllData = repository.readAllData
    }

    fun addPicture(picture: Picture) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.addPicture(picture)
            }
        }
    }

    fun deletePicture(picture: Picture) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.deletePicture(picture)
            }
        }
    }

    fun updatePicture(picture: Picture) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.updatePicture(picture)
            }
        }
    }
}