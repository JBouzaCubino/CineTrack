package com.bouzajesus.cinetrack.presentation.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.domain.models.Genres

sealed class GenresModel(genre: Genres, @StringRes val name: Int, @DrawableRes val image: Int) {
    data object Action : GenresModel(Genres.Action, R.string.action_genre, R.drawable.ic_action)
    data object Adventure : GenresModel(
        Genres.Adventure,
        R.string.adventure_genre,
        R.drawable.ic_adventure
    )

    data object Anime : GenresModel(Genres.Anime, R.string.anime_genre, R.drawable.ic_anime)
    data object Animation : GenresModel(
        Genres.Animation,
        R.string.animation_genre,
        R.drawable.ic_animation
    )

    data object Biography : GenresModel(
        Genres.Biography,
        R.string.biography_genre,
        R.drawable.ic_biography
    )

    data object Comedy : GenresModel(Genres.Comedy, R.string.comedy_genre, R.drawable.ic_comedy)
    data object Crime : GenresModel(Genres.Crime, R.string.crime_genre, R.drawable.ic_crime)
    data object Documentary : GenresModel(
        Genres.Documentary,
        R.string.documentary_genre,
        R.drawable.ic_documentary
    )

    data object Drama : GenresModel(Genres.Drama, R.string.drama_genre, R.drawable.ic_drama)
    data object Familiar : GenresModel(
        Genres.Familiar,
        R.string.familiar_genre,
        R.drawable.ic_familiar
    )

    data object Fantasy : GenresModel(Genres.Fantasy, R.string.fantasy_genre, R.drawable.ic_fantasy)
    data object Gameshow : GenresModel(
        Genres.Gameshow,
        R.string.gameshow_genre,
        R.drawable.ic_gameshow
    )

    data object History : GenresModel(Genres.History, R.string.history_genre, R.drawable.ic_history)
    data object Horror : GenresModel(Genres.Horror, R.string.horror_genre, R.drawable.ic_horror)
    data object Lifestyle : GenresModel(
        Genres.Lifestyle,
        R.string.lifestyle_genre,
        R.drawable.ic_lifestyle
    )

    data object Music : GenresModel(Genres.Music, R.string.music_genre, R.drawable.ic_music)
    data object Musical : GenresModel(Genres.Musical, R.string.musical_genre, R.drawable.ic_musical)
    data object Mystery : GenresModel(Genres.Mystery, R.string.mystery_genre, R.drawable.ic_mystery)
    data object Reality : GenresModel(Genres.Reality, R.string.reality_genre, R.drawable.ic_reality)
    data object Romance : GenresModel(Genres.Romance, R.string.romance_genre, R.drawable.ic_romance)
    data object Scifi : GenresModel(Genres.Scifi, R.string.scifi_genre, R.drawable.ic_scifi)
    data object Short : GenresModel(Genres.Short, R.string.short_genre, R.drawable.ic_short)
    data object Sport : GenresModel(Genres.Sport, R.string.sport_genre, R.drawable.ic_sport)
    data object Suspense : GenresModel(
        Genres.Suspense,
        R.string.suspense_genre,
        R.drawable.ic_suspense
    )

    data object Thriller : GenresModel(
        Genres.Thriller,
        R.string.thriller_genre,
        R.drawable.ic_thriller
    )

    data object War : GenresModel(Genres.War, R.string.war_genre, R.drawable.ic_war)
    data object Western : GenresModel(Genres.Western, R.string.western_genre, R.drawable.ic_western)
    data object Other : GenresModel(Genres.Other, R.string.other_genre, R.drawable.ic_unknown)
}