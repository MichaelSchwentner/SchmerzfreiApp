package com.example.schmerzfreiapp.ui.uebungen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.schmerzfreiapp.data.model.Datasource
import com.example.schmerzfreiapp.data.model.Uebungen

class UebungenViewModel : ViewModel() {
    var categories: MutableLiveData<List<Uebungen>> = MutableLiveData(Datasource().getUebungsbilder())

}