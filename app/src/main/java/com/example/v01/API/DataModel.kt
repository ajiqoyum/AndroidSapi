package com.example.v01.API

import java.io.Serializable

data class DataModel(
    val data: List<Data>
){
    data class Data(val id:String?, val namacow:String?, val jkcow:String?,val umur:String?,val berat:String?,val jenis:String?,val kondisi:String?,val catatan:String?,val liveAct:String?,val liveLoc:String?): Serializable
}
