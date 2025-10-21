package com.bouzajesus.cinetrack.domain.models

import com.bouzajesus.cinetrack.data.remote.PrimaryImageItem
import com.bouzajesus.cinetrack.data.remote.RatingItem
import com.google.gson.annotations.SerializedName

data class Media(
    val type: String,
    val primaryTitle: String,
    val primaryImageUrl: String,
    val startYear: Int,
    val aggregateRating: Float,
    val voteCount: Int,
    val plot: String
)
