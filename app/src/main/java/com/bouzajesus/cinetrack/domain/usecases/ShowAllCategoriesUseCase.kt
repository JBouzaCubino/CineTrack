package com.bouzajesus.cinetrack.domain.usecases

import com.bouzajesus.cinetrack.domain.models.Category
import com.bouzajesus.cinetrack.domain.repositories.Repository
import javax.inject.Inject

class ShowAllCategoriesUseCase @Inject constructor(private val repository: Repository) {

    suspend fun execute(): List<Category> {
        return repository.getCategories()
    }

}