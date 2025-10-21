package com.bouzajesus.cinetrack.domain.repositories

import com.bouzajesus.cinetrack.domain.models.Media

interface Repository {

    suspend fun getAllTitles(): List<Media>
}