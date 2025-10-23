package com.bouzajesus.cinetrack.di

import com.bouzajesus.cinetrack.data.RepositoryImpl
import com.bouzajesus.cinetrack.data.remote.ApiService
import com.bouzajesus.cinetrack.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(mediaApiService: ApiService): Repository{
        return RepositoryImpl(mediaApiService)
    }
}