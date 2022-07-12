package com.example.v01.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestRaw {
    //Karena API yang digunakan membutuhkan input Body Raw JSON

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("namacow")
    @Expose
    var namacow: String? = null

    @SerializedName("jkcow")
    @Expose
    var jkcow: String? = null

    @SerializedName("jenis")
    @Expose
    var jenis: String? = null

    @SerializedName("kondisi")
    @Expose
    var kondisi: String? = null

    @SerializedName("berat")
    @Expose
    var berat: String? = null

    @SerializedName("umur")
    @Expose
    var umur: String? = null

    @SerializedName("catatan")
    @Expose
    var catatan: String? = null

    @SerializedName("liveAct")
    @Expose
    var liveAct: String? = null

    @SerializedName("liveLoc")
    @Expose
    var liveLoc: String? = null
}