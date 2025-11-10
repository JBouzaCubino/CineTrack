package com.bouzajesus.cinetrack.domain.usecases

import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import javax.inject.Inject

class GetShowByIdUseCase @Inject constructor(private val repository: Repository) {

    suspend fun execute(showId: String): Media{
        return repository.getShowById(showId)
    }

}