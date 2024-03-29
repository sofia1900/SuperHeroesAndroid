package com.sofia.superHero.features.superHero.data.work.di

import com.sofia.superHero.app.data.local.AppDatabase
import com.sofia.superHero.features.superHero.data.work.local.room.WorkDao
import com.sofia.superHero.features.superHero.data.work.remote.WorkApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class WorkProvides {
    @Provides
    fun provideWorkApiService(retrofit: Retrofit): WorkApiService =
        retrofit.create(WorkApiService::class.java)

    @Provides
    fun provideWorkDao(appDatabase: AppDatabase): WorkDao = appDatabase.workDao()
}