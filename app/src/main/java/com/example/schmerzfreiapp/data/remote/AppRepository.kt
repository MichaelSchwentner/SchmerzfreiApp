package com.example.schmerzfreiapp.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.schmerzfreiapp.data.model.ApiResponseDataFolder
import com.example.schmerzfreiapp.data.model.ApiResponseDataVideo

class AppRepository(private val api: VimeoApi) {
    val video = MutableLiveData<ApiResponseDataVideo>()
    val folder = MutableLiveData<ApiResponseDataFolder>()
    suspend fun getFolder() {
        try {
            folder.value =

                api.retrofitService.getAllFoldersFromUser()

        } catch (e: Exception) {
            Log.e("Repository", "Error loading data from API: $e")
        }
    }
    suspend fun getVideo(project_id : String) {
        try {
            video.value =

                api.retrofitService.getAllVideosFromFolder(project_id)

        } catch (e: Exception) {
            Log.e("Repository", "Error loading data from API: $e")
        }
    }
}