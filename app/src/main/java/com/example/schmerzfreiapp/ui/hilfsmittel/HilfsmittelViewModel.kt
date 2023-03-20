package com.example.schmerzfreiapp.ui.hilfsmittel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HilfsmittelViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "HILFSMITTEL ZUR SELBSTBEHANDLUNG"
    }
    val text: LiveData<String> = _text
}