package com.sofia.superHero.features.superHero.data.work.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkEntity (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "occupation") val occupation: String,
)