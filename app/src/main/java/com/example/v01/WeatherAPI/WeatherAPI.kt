package com.example.v01.WeatherAPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lat") latitude : String,
        @Query("lon") longitude : String,
        @Query("appid") apiKey : String,
        @Query("units") units : String,
    ) : Call<Cuaca>
}