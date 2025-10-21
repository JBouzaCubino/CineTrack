package com.bouzajesus.cinetrack.data.remote

import com.bouzajesus.cinetrack.domain.models.Media
import com.google.gson.annotations.SerializedName

data class MediaDataModel(
    @SerializedName("titles") val titles: List<MediaItem>
){
    fun toDomain(): List<Media> {
        return this.titles.map {
            Media(
                it.type,
            it.primaryTitle,
            it.primaryImage.url,
            it.startYear,
            it.rating?.aggregateRating ?: 0f,
            it.rating?.voteCount ?: 0,
            it.plot
            )
        }
    }
}

data class MediaItem(
    @SerializedName("type") val type: String,
    @SerializedName("primaryTitle") val primaryTitle: String,
    @SerializedName("primaryImage") val primaryImage: PrimaryImageItem,
    @SerializedName("startYear") val startYear: Int,
    @SerializedName("rating") val rating: RatingItem?,
    @SerializedName("plot") val plot: String
)//{
//    fun toDomain(): Media {
//        return Media(
//            this.type,
//            this.primaryTitle,
//            this.primaryImage.url,
//            this.startYear,
//            this.rating.aggregateRating,
//            this.rating.voteCount,
//            this.plot
//        )
//    }
//}

data class PrimaryImageItem(
    @SerializedName("url") val url: String
)

data class RatingItem(
    @SerializedName("aggregateRating") val aggregateRating: Float,
    @SerializedName("voteCount") val voteCount: Int
)
