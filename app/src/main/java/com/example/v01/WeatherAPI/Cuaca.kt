package com.example.v01.WeatherAPI

import java.io.Serializable

data class Cuaca(
    val main: Main

    ){
//    data class Weather(val id:Int?, val main:String?, val description: String?):Serializable
    data class Main(val temp:Double):Serializable
}

//    @field:SerializedName("name")
//    val city: String,
//
//    @field:SerializedName("weather")
//    val weather: List<WeatherItem>,
//
//    @field:SerializedName("main")
//    val main: Main,

//data class ListItem(
//
//    @field:SerializedName("dt")
//    val dt: Int,
//
//    @field:SerializedName("dt_txt")
//    val dtTxt: String,
//
//    @field:SerializedName("weather")
//    val weather: List<WeatherItem>,
//
//    @field:SerializedName("main")
//    val main: Main,
//)
//
//data class WeatherItem!!(
//
//    @field:SerializedName("description")
//    val description: String,
//
//    @field:SerializedName("main")
//    val main: String,
//
//    )
//
//data class Main!!(
//
//    @field:SerializedName("temp")
//    val temp: Double,
//
//    @field:SerializedName("temp_min")
//    val tempMin: Double,
//
//    @field:SerializedName("temp_max")
//    val tempMax: Double
//)
//
//data class City(
//
//    @field:SerializedName("country")
//    val country: String,
//
//    @field:SerializedName("name")
//    val name: String,
//)