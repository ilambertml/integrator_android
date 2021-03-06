package com.example.integrator_android.Model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getActivity(@Url query : String): Response<ActivityResponse>

}