package com.sofia.superHero.features.superHero.data.hero.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sofia.superHero.features.superHero.domain.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM heroentity")
    suspend fun getAll(): List<HeroEntity>

    @Query("SELECT * FROM heroentity WHERE id IN (:id)")
    suspend fun getById(id : String): HeroEntity?

    @Insert
    suspend fun insert(hero: HeroEntity)

}