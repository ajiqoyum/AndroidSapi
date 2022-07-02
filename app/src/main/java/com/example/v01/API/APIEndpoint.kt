package com.example.v01.API

import retrofit2.Call
import retrofit2.http.*

interface APIEndpoint {

    @GET("all-sapi")
    fun data(): Call<DataModel>

    @Headers("Content-Type: application/json")
    @POST("sapi")
    fun getRaw(@Body req : RequestRaw): Call<SubmitModel>

    @Headers("Content-Type: application/json")
    @POST("sapi")
    fun Update(@Body req : RequestRaw): Call<SubmitModel>

    @Headers("Content-Type: application/json")
    @PATCH("sapi")
    fun UpdateCttn(@Body req: updateJson): Call<SubmitModel>

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "sapi", hasBody = true)
    fun deletejson(@Body req: deleteJson): Call<SubmitModel>
}