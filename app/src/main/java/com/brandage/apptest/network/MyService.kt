package com.brandage.apptest.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface MyService {

    @GET("v3/c5c7f184-ef52-4e0f-bf2d-aaf59d3adf65alance")
    fun getRecords(): Call<JsonObject?>
}