package com.bouzajesus.cinetrack.data.remote.models

import com.bouzajesus.cinetrack.domain.models.Genres
import com.bouzajesus.cinetrack.domain.models.Media
import com.google.gson.annotations.SerializedName

data class MediaDataResponseModel(
    @SerializedName("titles") val titles: List<MediaItem>
)

data class MediaItem(
    @SerializedName("id") val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("primaryTitle") val primaryTitle: String,
    @SerializedName("primaryImage") val primaryImage: PrimaryImageItem?,
    @SerializedName("genres") val genres: List<String>,
    @SerializedName("rating") val rating: Rating?,
    @SerializedName("plot") val plot: String
)

data class PrimaryImageItem(
    @SerializedName("url") val url: String
)

data class Rating(
    @SerializedName("aggregateRating") val aggregateRating: Float,
    @SerializedName("voteCount") val voteCount: Int
)
