package com.bouzajesus.cinetrack.data

import com.bouzajesus.cinetrack.data.mappers.DataDomainMapper
import com.bouzajesus.cinetrack.data.remote.ApiService
import com.bouzajesus.cinetrack.data.remote.models.MediaDataResponseModel
import com.bouzajesus.cinetrack.data.remote.models.MediaItem
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import okio.IOException
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val apiService: ApiService) : Repository {

    override suspend fun getAllTitles(): List<Media>{
        val response: Response<MediaDataResponseModel> = apiService.getTitles()

        return responseMediaCheck(response)
    }

    override suspend fun getShowByName(name: String): List<Media> {
        val response: Response<MediaDataResponseModel> = apiService.getTitleByName(name)

        return responseMediaCheck(response)
    }

    override suspend fun getShowById(showId: String): Media {
        val response = apiService.getTitleById(showId)

        return responseMediaItemCheck(response)
    }

    private fun responseMediaCheck(response: Response<MediaDataResponseModel>): List<Media>{
        if(response.isSuccessful){
            return DataDomainMapper.toDomain(response.body())
        }
        else{
            throw IOException("${response.code()}: ${response.message()}")
        }
    }

    private fun responseMediaItemCheck(response: Response<MediaItem>): Media{
        if(response.isSuccessful){
            return DataDomainMapper.toDomain(response.body())
        }
        else{
            throw IOException("${response.code()}: ${response.message()}")
        }
    }
}