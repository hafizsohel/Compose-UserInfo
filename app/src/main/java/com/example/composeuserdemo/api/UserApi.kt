package com.example.composeuserdemo.api

import com.example.composeuserdemo.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface UserApi {

    @GET("/v3/b/688ee1fff7e7a370d1f29755?meta=false")
    suspend fun getUsers(@Header("X-JSON-Path") category: String): Response<List<Users>>



    @GET("/v3/b/688ee1fff7e7a370d1f29755?meta=false")
    @Headers("X-JSON-Path: users..category")
    suspend fun getCategories(): Response<List<String>>
}