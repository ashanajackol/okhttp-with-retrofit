package com.example.ashana.retrofitwithokhttp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("/api/users?")
    fun gteResources( @Query("page") page: Int ): Call<Resources>
}