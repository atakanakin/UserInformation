package com.atakan.userinformation

import retrofit2.Response
import retrofit2.http.GET

interface IpApi {
    @GET("json")
    suspend fun getInfo() : Response<Information>
}