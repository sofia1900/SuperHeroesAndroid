package com.sofia.superHero.features.superHero.data.biography.di

import com.sofia.superHero.app.data.local.AppDatabase
import com.sofia.superHero.features.superHero.data.biography.local.room.BiographyDao
import com.sofia.superHero.features.superHero.data.biography.remote.BiographyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class BiographyProvides {

    @Provides
    fun provideBiographyApiService(retrofit: Retrofit): BiographyApiService =
        retrofit.create(BiographyApiService::class.java)

    @Provides
    fun provideBiographyDao (appDatabase: AppDatabase) : BiographyDao = appDatabase.biographyDao()
}