package com.example.v01

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIEndpoint {

    @GET("read.php")
    fun data(): Call<DataModel>

    @FormUrlEncoded
    @POST("create.php")
    fun create(
        @Field("namacow") namasp: String,
        @Field("jkcow") jksp: String,
        @Field("umur") umursp: String,
        @Field("berat") beratsp: String,
        @Field("jenis") jenissp: String,
        @Field("kondisi") kondisisp: String,
        @Field("catatan") catatansp: String
    ) : Call<SubmitModel>

    @FormUrlEncoded
    @POST("update.php")
    fun update(
        @Field("id") id: String,
        @Field("namacow") namasp: String,
        @Field("jkcow") jksp: String,
        @Field("umur") umursp: String,
        @Field("berat") beratsp: String,
        @Field("jenis") jenissp: String,
        @Field("kondisi") kondisisp: String,
        @Field("catatan") catatansp: String
    ) : Call<SubmitModel>

    @FormUrlEncoded
    @POST("delete.php")
    fun delete(
        @Field("id") id: String
    ) : Call<SubmitModel>
}