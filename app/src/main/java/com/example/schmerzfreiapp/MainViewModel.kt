package com.example.schmerzfreiapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schmerzfreiapp.data.remote.AppRepository
import com.example.schmerzfreiapp.data.remote.VimeoApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repository = AppRepository(VimeoApi)
    val videos = repository.video
    val folder = repository.folder
    private val _currentFolder : MutableLiveData<String> = MutableLiveData()
    val currentFolder: MutableLiveData<String>
        get() = _currentFolder

    fun getFolder(){
        viewModelScope.launch { repository.getFolder() }
    }
    fun getVideo(){
        viewModelScope.launch { repository.getVideo(currentFolder.value!!) }

    }
    fun setCurrentFolder(folder:String){
        _currentFolder.value = folder
    }
}
