package com.bouzajesus.cinetrack.domain.usecases

import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.repositories.Repository
import javax.inject.Inject

class ShowAllShowsUseCase @Inject constructor(private val repository: Repository) {

    suspend fun execute(): List<Media>{
        return repository.getAllTitles()
    }
}