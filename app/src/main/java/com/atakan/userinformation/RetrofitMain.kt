package com.atakan.userinformation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMain {

    private val baseUrl = "https://ipapi.co/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}