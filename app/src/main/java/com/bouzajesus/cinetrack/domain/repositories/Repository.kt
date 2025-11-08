package com.bouzajesus.cinetrack.domain.repositories

import com.bouzajesus.cinetrack.domain.models.Category
import com.bouzajesus.cinetrack.domain.models.Media

interface Repository {

    suspend fun getAllTitles(): List<Media>

    suspend fun getShowByName(name: String): List<Media>

    suspend fun getCategories(): List<Category>
}