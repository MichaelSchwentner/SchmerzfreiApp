package com.example.schmerzfreiapp.ui.UebungDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UebungDetailViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Übungen"
    }
    val text: LiveData<String> = _text
}