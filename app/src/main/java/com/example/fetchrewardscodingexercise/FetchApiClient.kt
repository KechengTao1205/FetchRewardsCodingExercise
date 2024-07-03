package com.example.fetchrewardscodingexercise

object FetchApiClient {
    val fetchApi: FetchApi by lazy {
        RetrofitClient.retrofit.create(FetchApi::class.java)
    }
}