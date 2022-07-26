package com.brandage.apptest.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.brandage.apptest.models.AssociatedDrugsModel
import com.google.gson.JsonObject
import com.brandage.apptest.network.APIClient
import com.brandage.apptest.network.MyService
import com.brandage.apptest.utils.SharedFile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository(application: Application) {

    private var myService: MyService
    = APIClient.getCacheEnabledRetrofit(application).create(MyService::class.java)

    fun getRecords(): MutableLiveData<List<AssociatedDrugsModel>?> {
        val jsonList = mutableListOf<AssociatedDrugsModel>()
        val list = MutableLiveData<List<AssociatedDrugsModel>?>()
        val getAllCall = myService.getRecords()
        getAllCall.enqueue(object : Callback<JsonObject?> {

            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful && response.code() == 200) {
                    val jsonObject = response.body()!!
                        .getAsJsonArray("problems")
                    val diabetes = jsonObject.map { it.asJsonObject.getAsJsonArray("Diabetes") }

                    val medications = diabetes.map { it.asJsonObject.getAsJsonArray("medications") }

                    val medicationsClasses = medications.map { it.asJsonObject.getAsJsonArray("medicationsClasses") }

                    val className = medicationsClasses.map { it.asJsonObject.getAsJsonArray("className") }

                    className.forEach {
                        val associatedDrugsModel = AssociatedDrugsModel(
                            it.asJsonObject.get("name").asString,
                            it.asJsonObject.get("description").asString,
                            it.asJsonObject.get("image").asString
                        )
                        jsonList.add(associatedDrugsModel)
                    }

                    list.value = jsonList
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {

            }

        })
        return list
    }

}