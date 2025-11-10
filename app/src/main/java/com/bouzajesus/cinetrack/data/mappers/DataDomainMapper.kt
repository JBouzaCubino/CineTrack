package com.bouzajesus.cinetrack.data.mappers

import com.bouzajesus.cinetrack.data.remote.models.MediaDataResponseModel
import com.bouzajesus.cinetrack.data.remote.models.MediaItem
import com.bouzajesus.cinetrack.domain.models.Genres
import com.bouzajesus.cinetrack.domain.models.Media

class DataDomainMapper {

    companion object{

        private fun getMediaFromMediaItem(mediaItem: MediaItem): Media{

            val genresList: List<Genres> = mapToGenre(mediaItem.genres)

            //Map from rating over 10 to rating over 5
            val aggregateRatingMapped: Float = mediaItem.rating?.aggregateRating?.div(2) ?: 0f

            return Media(
                mediaItem.id,
                mediaItem.type,
                mediaItem.primaryTitle,
                mediaItem.primaryImage?.url ?: "",
                genresList,
                mediaItem.plot,
                aggregateRatingMapped,
                mediaItem.rating?.voteCount ?: 0
            )
        }

        fun toDomain(media: MediaDataResponseModel?): List<Media> {

            return media?.titles?.map {

                getMediaFromMediaItem(it)
            } ?: emptyList()
        }

        fun toDomain(media: MediaItem?): Media {

            return getMediaFromMediaItem(media ?: throw NoSuchElementException("El MediaItem es nulo y es un valor requerido."))

        }

        private fun mapToGenre(value: List<String>): List<Genres> {
            return value.map {
                when(it.lowercase()){
                    "action" -> Genres.Action
                    "adventure" -> Genres.Adventure
                    "animation" -> Genres.Animation
                    "anime" -> Genres.Anime
                    "biography" -> Genres.Biography
                    "comedy" -> Genres.Comedy
                    "crime" -> Genres.Crime
                    "documentary" -> Genres.Documentary
                    "drama" -> Genres.Drama
                    "familiar" -> Genres.Familiar
                    "fantasy" -> Genres.Fantasy
                    "gameshow" -> Genres.Gameshow
                    "history" -> Genres.History
                    "horror" -> Genres.Horror
                    "lifestyle" -> Genres.Lifestyle
                    "music" -> Genres.Music
                    "musical" -> Genres.Musical
                    "mystery" -> Genres.Mystery
                    "reality" -> Genres.Reality
                    "romance" -> Genres.Romance
                    "scifi" -> Genres.Scifi
                    "short" -> Genres.Short
                    "sport" -> Genres.Sport
                    "suspense" -> Genres.Suspense
                    "thriller" -> Genres.Thriller
                    "war" -> Genres.War
                    "western" -> Genres.Western
                    else -> Genres.Unknown
                }
            }
        }
    }



}