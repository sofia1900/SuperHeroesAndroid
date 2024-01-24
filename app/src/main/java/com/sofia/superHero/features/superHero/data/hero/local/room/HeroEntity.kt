package com.sofia.superHero.features.superHero.data.hero.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroEntity (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "intelligence") val intelligence: String,
    @ColumnInfo(name = "strength") val strength: String,
    @ColumnInfo(name = "speed") val speed: String,
    @ColumnInfo(name = "durability") val durability: String,
    @ColumnInfo(name = "power") val power: String,
    @ColumnInfo(name = "combat") val combat: String
)

