package com.example.feeder.ui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddRSSViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ADD RSS"
    }
    val text: LiveData<String> = _text
}