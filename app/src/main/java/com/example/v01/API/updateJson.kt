package com.example.v01.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class updateJson {
    //Karena API yang digunakan membutuhkan input Body Raw JSON

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("updateKey")
    @Expose
    var updateKey: String? = null

    @SerializedName("updateValue")
    @Expose
    var updateValue: String? = null
}