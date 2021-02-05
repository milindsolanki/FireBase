package com.example.firebase.api

import com.example.firebase.beans.Data1
import com.example.firebase.beans.Example
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("marvel")
    fun getData(): Call<List<Data1>>

    /*@GET("users")
    fun getUserData(): Call<Example>*/
    @GET("users")
    fun getUserData(): Call<List<Example>>
}