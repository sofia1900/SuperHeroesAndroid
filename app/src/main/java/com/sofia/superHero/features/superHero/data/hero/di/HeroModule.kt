package com.sofia.superHero.features.superHero.data.hero.di

import com.sofia.superHero.features.superHero.data.hero.HeroDataRepository
import com.sofia.superHero.features.superHero.data.hero.local.HeroLocalDataSource
import com.sofia.superHero.features.superHero.data.hero.local.room.HeroLocalDbDataSource
import com.sofia.superHero.features.superHero.domain.HeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HeroModule {
    @Binds
    abstract fun bindHeroDataRepository(heroDataRepository: HeroDataRepository): HeroRepository

    @Binds
    abstract fun bindHeroLocalDataSource(heroLocalDbDataSource: HeroLocalDbDataSource): HeroLocalDataSource
}