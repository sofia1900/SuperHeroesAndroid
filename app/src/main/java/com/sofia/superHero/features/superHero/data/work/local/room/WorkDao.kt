package com.sofia.superHero.features.superHero.data.work.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkDao {
    @Query("SELECT * FROM workentity WHERE id IN (:id)")
    suspend fun getById(id: String): WorkEntity?

    @Insert
    suspend fun insert(work: WorkEntity)
}