package com.example.examplerest.data.remote

import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    suspend fun <T> sendGET(@Url url: String): Map<String, Any?>?
}