package com.example.v01.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class deleteJson {
    //Karena API yang digunakan membutuhkan input Body Raw JSON

    @SerializedName("id")
    @Expose
    var id: String? = null
}