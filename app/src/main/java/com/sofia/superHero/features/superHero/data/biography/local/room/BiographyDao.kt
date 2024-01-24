package com.sofia.superHero.features.superHero.data.biography.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BiographyDao {
    @Query("SELECT * FROM biographyentity WHERE id IN (:id)")
    suspend fun getById(id : String): BiographyEntity?

    @Insert
    suspend fun insert(biography: BiographyEntity)

}