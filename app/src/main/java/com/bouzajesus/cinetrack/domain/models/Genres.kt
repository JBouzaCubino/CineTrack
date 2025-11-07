package com.bouzajesus.cinetrack.domain.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.bouzajesus.cinetrack.R

sealed class Genres(@StringRes val name:Int, @DrawableRes val image: Int) {
    data object Action: Genres(R.string.action_genre,R.drawable.ic_action)
    data object Adventure: Genres(R.string.adventure_genre,R.drawable.ic_adventure)
    data object Anime: Genres(R.string.anime_genre,R.drawable.ic_anime)
    data object Animation: Genres(R.string.animation_genre,R.drawable.ic_animation)
    data object Biography: Genres(R.string.biography_genre,R.drawable.ic_biography)
    data object Comedy: Genres(R.string.comedy_genre,R.drawable.ic_comedy)
    data object Crime: Genres(R.string.crime_genre,R.drawable.ic_crime)
    data object Documentary: Genres(R.string.documentary_genre,R.drawable.ic_documentary)
    data object Drama: Genres(R.string.drama_genre,R.drawable.ic_drama)
    data object Familiar: Genres(R.string.familiar_genre,R.drawable.ic_familiar)
    data object Fantasy: Genres(R.string.fantasy_genre,R.drawable.ic_fantasy)
    data object Gameshow: Genres(R.string.gameshow_genre,R.drawable.ic_gameshow)
    data object History: Genres(R.string.history_genre,R.drawable.ic_history)
    data object Horror: Genres(R.string.horror_genre,R.drawable.ic_horror)
    data object Lifestyle: Genres(R.string.lifestyle_genre,R.drawable.ic_lifestyle)
    data object Music: Genres(R.string.music_genre,R.drawable.ic_music)
    data object Musical: Genres(R.string.musical_genre,R.drawable.ic_musical)
    data object Mystery: Genres(R.string.mystery_genre,R.drawable.ic_mystery)
    data object Reality: Genres(R.string.reality_genre,R.drawable.ic_reality)
    data object Romance: Genres(R.string.romance_genre,R.drawable.ic_romance)
    data object Scifi: Genres(R.string.scifi_genre,R.drawable.ic_scifi)
    data object Short: Genres(R.string.short_genre,R.drawable.ic_short)
    data object Sport: Genres(R.string.sport_genre,R.drawable.ic_sport)
    data object Suspense: Genres(R.string.suspense_genre,R.drawable.ic_suspense)
    data object Thriller: Genres(R.string.thriller_genre,R.drawable.ic_thriller)
    data object War: Genres(R.string.war_genre,R.drawable.ic_war)
    data object Western: Genres(R.string.western_genre, R.drawable.ic_western)
}