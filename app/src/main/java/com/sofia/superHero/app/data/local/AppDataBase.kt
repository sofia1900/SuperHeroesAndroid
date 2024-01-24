package com.sofia.superHero.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sofia.superHero.features.superHero.data.biography.local.room.BiographyDao
import com.sofia.superHero.features.superHero.data.biography.local.room.BiographyEntity
import com.sofia.superHero.features.superHero.data.hero.local.room.HeroDao
import com.sofia.superHero.features.superHero.data.hero.local.room.HeroEntity
import com.sofia.superHero.features.superHero.data.work.local.room.WorkDao
import com.sofia.superHero.features.superHero.data.work.local.room.WorkEntity

@Database(
    entities = [BiographyEntity::class, HeroEntity::class, WorkEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun biographyDao(): BiographyDao
    abstract fun heroDao(): HeroDao
    abstract fun workDao(): WorkDao
}