package com.example.fetchrewardscodingexercise.domain

object FetchApiClient {
    val fetchApi: FetchApi by lazy {
        RetrofitClient.retrofit.create(FetchApi::class.java)
    }
}