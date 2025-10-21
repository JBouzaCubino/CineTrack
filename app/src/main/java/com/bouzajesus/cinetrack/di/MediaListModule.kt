package com.bouzajesus.cinetrack.di

import com.bouzajesus.cinetrack.domain.models.Media
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MediaListModule {

    @Provides
    fun provideMediaList(): List<Media>{
        return emptyList()
    }
}