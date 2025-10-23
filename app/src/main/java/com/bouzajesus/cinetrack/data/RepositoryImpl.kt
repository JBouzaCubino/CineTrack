package com.bouzajesus.cinetrack.data

import com.bouzajesus.cinetrack.data.remote.ApiService
import com.bouzajesus.cinetrack.data.remote.models.MediaDataResponseModel
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import okio.IOException
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val mediaApiService: ApiService) : Repository {

    override suspend fun getAllTitles(): List<Media>{
        val response: Response<MediaDataResponseModel> = mediaApiService.getTitles()

        return responseCheck(response)
    }

    override suspend fun getShowByName(name: String): List<Media> {
        val response: Response<MediaDataResponseModel> = mediaApiService.getTitleByName(name)

        return responseCheck(response)
    }

    private fun responseCheck(response: Response<MediaDataResponseModel>): List<Media>{
        if(response.isSuccessful){
            return response.body()?.toDomain() ?: emptyList()
        }
        else{
            throw IOException("${response.code()}: ${response.message()}")
        }
    }
}