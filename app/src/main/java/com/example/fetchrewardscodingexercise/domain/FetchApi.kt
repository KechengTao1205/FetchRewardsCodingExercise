package com.example.fetchrewardscodingexercise.domain

import com.example.fetchrewardscodingexercise.model.FetchItem
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getFetchItems() : List<FetchItem>
}