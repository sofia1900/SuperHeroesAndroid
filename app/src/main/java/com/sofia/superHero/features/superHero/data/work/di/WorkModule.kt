package com.sofia.superHero.features.superHero.data.work.di

import com.sofia.superHero.features.superHero.data.work.WorkDataRepository
import com.sofia.superHero.features.superHero.data.work.local.WorkLocalDataSource
import com.sofia.superHero.features.superHero.data.work.local.room.WorkLocalDbDataSource
import com.sofia.superHero.features.superHero.domain.WorkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class WorkModule {
    @Binds
    abstract fun bindWorkDataRepository(workDataRepository: WorkDataRepository): WorkRepository

    @Binds
    abstract fun bindWorkLocalDataSource(workLocalDbDataSource: WorkLocalDbDataSource): WorkLocalDataSource
}