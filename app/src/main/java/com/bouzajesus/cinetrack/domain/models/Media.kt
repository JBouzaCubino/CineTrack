package com.bouzajesus.cinetrack.domain.models

data class Media(
    val id: String,
    val type: String,
    val primaryTitle: String,
    val primaryImageUrl: String,
    val genres: List<Genres>,
    val plot: String?,
    val rating: Float,
    val voteCount: Int
)
