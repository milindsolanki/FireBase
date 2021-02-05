package com.example.firebase.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    //private var BASE_URL = "https://simplifiedcoding.net/demos/"
    //private var BASE_URL = "https://reqres.in/api/"
    private var BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null
    val clint: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}