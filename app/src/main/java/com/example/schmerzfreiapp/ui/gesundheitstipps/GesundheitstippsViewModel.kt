package com.example.schmerzfreiapp.ui.gesundheitstipps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GesundheitstippsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "GESUNDHEITSTIPPS"
    }
    val text: LiveData<String> = _text
}