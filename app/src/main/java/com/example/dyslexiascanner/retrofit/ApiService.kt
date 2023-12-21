package com.example.dyslexiascanner.retrofit

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {

    @Multipart
    @POST("predict")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part,
    ): PostResponse

    @GET("get_predict")
    fun getPrediction(): Call<GetResponse>




}