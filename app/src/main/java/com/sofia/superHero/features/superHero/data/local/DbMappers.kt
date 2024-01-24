package com.sofia.superHero.features.superHero.data.local

import com.sofia.superHero.features.superHero.data.biography.local.room.BiographyEntity
import com.sofia.superHero.features.superHero.data.hero.local.room.HeroEntity
import com.sofia.superHero.features.superHero.data.work.local.room.WorkEntity
import com.sofia.superHero.features.superHero.domain.Biography
import com.sofia.superHero.features.superHero.domain.Hero
import com.sofia.superHero.features.superHero.domain.Work

fun BiographyEntity.toModel() = Biography(this.id, this.fullName, this.alignment)
fun Biography.toEntity() = BiographyEntity(this.id, this.fullName, this.alignment)

fun HeroEntity.toModel() = Hero(this.id, this.name, this.image, this.intelligence, this.strength, this.speed, this.durability, this.power, this.combat)
fun Hero.toEntity() = HeroEntity(this.id, this.name, this.image, this.intelligence, this.strength, this.speed, this.durability, this.power, this.combat)

fun WorkEntity.toModel() = Work(this.id, this.occupation)
fun Work.toEntity() = WorkEntity(this.id, this.occupation)