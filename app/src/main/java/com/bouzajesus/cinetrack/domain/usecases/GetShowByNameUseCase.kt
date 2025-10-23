package com.bouzajesus.cinetrack.domain.usecases

import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import jakarta.inject.Inject

class GetShowByNameUseCase @Inject constructor(private val repository: Repository){

    suspend fun execute(name: String): List<Media>{
        return repository.getShowByName(name)
    }
}