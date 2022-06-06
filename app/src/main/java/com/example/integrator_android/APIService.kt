package com.example.integrator_android

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getDogsFromAPI(@Url query : String): Response<ActivityResponse>
}