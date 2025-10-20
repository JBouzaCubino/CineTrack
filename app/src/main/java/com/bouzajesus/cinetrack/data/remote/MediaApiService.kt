package com.bouzajesus.cinetrack.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface MediaApiService {

    @GET("/titles")
    suspend fun getTitles(): Response<Media>
}