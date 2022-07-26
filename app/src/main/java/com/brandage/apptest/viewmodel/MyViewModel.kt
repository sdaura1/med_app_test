package com.brandage.apptest.viewmodel

import androidx.lifecycle.ViewModel
import com.brandage.apptest.repository.MyRepository
import com.google.gson.JsonObject

class MyViewModel(private val repository: MyRepository): ViewModel() {

    fun getRecords() = repository.getRecords()
}