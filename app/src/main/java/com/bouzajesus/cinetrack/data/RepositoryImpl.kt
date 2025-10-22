package com.bouzajesus.cinetrack.data

import com.bouzajesus.cinetrack.data.remote.MediaApiService
import com.bouzajesus.cinetrack.data.remote.MediaDataModel
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import okio.IOException
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val mediaApiService: MediaApiService) : Repository {

    override suspend fun getAllTitles(): List<Media>{
        val response: Response<MediaDataModel> = mediaApiService.getTitles()

        if(response.isSuccessful){
            return response.body()?.toDomain() ?: emptyList()
        }
        else{
            throw IOException("${response.code()}: ${response.message()}")
        }

    }
}