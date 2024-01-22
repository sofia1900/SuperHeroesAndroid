package com.sofia.superHero.app.di

import com.sofia.superHero.app.data.serialization.GsonSerialization
import com.sofia.superHero.app.data.serialization.JsonSerialization
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindJsonSerialization(gsonSerialization: GsonSerialization): JsonSerialization

}