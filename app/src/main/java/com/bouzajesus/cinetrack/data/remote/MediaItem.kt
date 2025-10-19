package com.bouzajesus.cinetrack.data.remote

import com.google.gson.annotations.SerializedName

data class MediaItem(
    @SerializedName("type") val type: String,
    @SerializedName("primaryTitle") val primaryTitle: String,
    @SerializedName("primaryImage") val primaryImage: PrimaryImageItem,
    @SerializedName("startYear") val startYear: Int,
    @SerializedName("rating") val rating: RatingItem,
    @SerializedName("plot") val plot: String
)

data class PrimaryImageItem(
    @SerializedName("url") val url: String
)

data class RatingItem(
    @SerializedName("aggregateRating") val aggregateRating: Float,
    @SerializedName("voteCount") val voteCount: Int
)
