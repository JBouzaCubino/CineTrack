package com.bouzajesus.cinetrack.data.remote

import com.bouzajesus.cinetrack.data.remote.models.CategoriesResponseModel
import com.bouzajesus.cinetrack.data.remote.models.MediaDataResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/titles")
    suspend fun getTitles(): Response<MediaDataResponseModel>

    @GET("/search/titles")
    suspend fun getTitleByName(@Query("query") query:String): Response<MediaDataResponseModel>

    @GET("/interests")
    suspend fun getInterests(): Response<CategoriesResponseModel>
}