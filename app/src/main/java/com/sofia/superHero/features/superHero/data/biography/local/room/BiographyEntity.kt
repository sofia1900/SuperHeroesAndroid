package com.sofia.superHero.features.superHero.data.biography.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BiographyEntity (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "alignment") val alignment: String
)