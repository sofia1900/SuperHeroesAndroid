package com.sofia.superHero.features.superHero.data.hero.di

import com.sofia.superHero.features.superHero.data.hero.remote.HeroApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HeroProvides {

    @Provides
    fun provideHeroApiService(retrofit: Retrofit): HeroApiService = retrofit.create(
        HeroApiService::class.java
    )
}