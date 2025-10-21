package com.bouzajesus.cinetrack.di

import com.bouzajesus.cinetrack.data.RepositoryImpl
import com.bouzajesus.cinetrack.data.RepositoryImpl_Factory
import com.bouzajesus.cinetrack.data.remote.MediaApiService
import com.bouzajesus.cinetrack.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(mediaApiService: MediaApiService): Repository{
        return RepositoryImpl(mediaApiService)
    }
}