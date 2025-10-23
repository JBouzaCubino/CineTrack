package com.bouzajesus.cinetrack.data.remote.models

import com.bouzajesus.cinetrack.domain.models.Media
import com.google.gson.annotations.SerializedName

data class MediaDataResponseModel(
    @SerializedName("titles") val titles: List<MediaItem>
){
    fun toDomain(): List<Media> {
        return this.titles.map {
            Media(
                it.type,
            it.primaryTitle,
            it.primaryImage?.url ?: ""
            )
        }
    }
}

data class MediaItem(
    @SerializedName("type") val type: String,
    @SerializedName("primaryTitle") val primaryTitle: String,
    @SerializedName("primaryImage") val primaryImage: PrimaryImageItem?
)

data class PrimaryImageItem(
    @SerializedName("url") val url: String
)
