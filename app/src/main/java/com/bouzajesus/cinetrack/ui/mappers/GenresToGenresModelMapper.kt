package com.bouzajesus.cinetrack.ui.mappers

import com.bouzajesus.cinetrack.domain.models.Genres
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.ui.models.GenresModel

class GenresToGenresModelMapper {

    companion object{
        fun mapGenresToGenresModel(media: Media): List<GenresModel> {

            return media.genres.map { genre ->
                when(genre){
                    Genres.Action -> GenresModel.Action
                    Genres.Adventure -> GenresModel.Adventure
                    Genres.Animation -> GenresModel.Animation
                    Genres.Anime -> GenresModel.Anime
                    Genres.Biography -> GenresModel.Biography
                    Genres.Comedy -> GenresModel.Comedy
                    Genres.Crime -> GenresModel.Crime
                    Genres.Documentary -> GenresModel.Documentary
                    Genres.Drama -> GenresModel.Drama
                    Genres.Familiar -> GenresModel.Familiar
                    Genres.Fantasy -> GenresModel.Fantasy
                    Genres.Gameshow -> GenresModel.Gameshow
                    Genres.History -> GenresModel.History
                    Genres.Horror -> GenresModel.Horror
                    Genres.Lifestyle -> GenresModel.Lifestyle
                    Genres.Music -> GenresModel.Music
                    Genres.Musical -> GenresModel.Musical
                    Genres.Mystery -> GenresModel.Mystery
                    Genres.Reality -> GenresModel.Reality
                    Genres.Romance -> GenresModel.Romance
                    Genres.Scifi -> GenresModel.Scifi
                    Genres.Short -> GenresModel.Short
                    Genres.Sport -> GenresModel.Sport
                    Genres.Suspense -> GenresModel.Suspense
                    Genres.Thriller -> GenresModel.Thriller
                    Genres.War -> GenresModel.War
                    Genres.Western -> GenresModel.Western
                    Genres.Unknown -> GenresModel.Unknown
                }
            }
        }
    }
}