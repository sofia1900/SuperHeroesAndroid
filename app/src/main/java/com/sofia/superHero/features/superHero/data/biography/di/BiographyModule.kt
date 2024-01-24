package com.sofia.superHero.features.superHero.data.biography.di

import com.sofia.superHero.features.superHero.data.biography.BiographyDataRepository
import com.sofia.superHero.features.superHero.data.biography.local.BiographyLocalDataSource
import com.sofia.superHero.features.superHero.data.biography.local.room.BiographyLocalDbDataSource
import com.sofia.superHero.features.superHero.domain.BiographyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BiographyModule {
    @Binds
    abstract fun bindBiographyDataRepository(biographyDataRepository: BiographyDataRepository): BiographyRepository

    @Binds
    abstract fun bindBiographyLocalDataRepository(biographyLocalDbDataSource: BiographyLocalDbDataSource): BiographyLocalDataSource
}