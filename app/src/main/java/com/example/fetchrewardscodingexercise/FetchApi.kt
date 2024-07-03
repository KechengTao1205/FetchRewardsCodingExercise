package com.example.fetchrewardscodingexercise

import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getFetchItems() : List<FetchItem>
}