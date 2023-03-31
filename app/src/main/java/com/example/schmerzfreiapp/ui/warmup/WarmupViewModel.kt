package com.example.schmerzfreiapp.ui.warmup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WarmupViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //   value = "This is Übungen Fragment"

    }
    val text: LiveData<String> = _text
}