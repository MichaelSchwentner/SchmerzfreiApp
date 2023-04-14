package com.example.schmerzfreiapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schmerzfreiapp.data.remote.AppRepository
import com.example.schmerzfreiapp.data.remote.VimeoApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repository = AppRepository(VimeoApi)
    val videos = repository.video
    val folder = repository.folder

    fun getFolder(){
        viewModelScope.launch { repository.getFolder() }
    }
    fun getVideo(){
        viewModelScope.launch { repository.getVideo("") }

    }
}
