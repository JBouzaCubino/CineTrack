package com.bouzajesus.cinetrack.domain.models

data class Media(
    val type: String,
    val primaryTitle: String,
    val primaryImageUrl: String,
    val plot: String,
    val rating: Float,
    val voteCount: Int
)
