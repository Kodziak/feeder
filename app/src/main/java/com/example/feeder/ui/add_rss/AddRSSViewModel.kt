package com.example.feeder.ui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddRSSViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ADD RSS Fragment"
    }
    val text: LiveData<String> = _text
}