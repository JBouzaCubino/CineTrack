package com.bouzajesus.cinetrack.di

import com.bouzajesus.cinetrack.data.remote.MediaItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MediaItemListModule {

    @Provides
    fun provideMediaItemList(): List<MediaItem>{
        return emptyList()
    }
}