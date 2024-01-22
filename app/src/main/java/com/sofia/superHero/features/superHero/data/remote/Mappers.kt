package com.sofia.superHero.features.superHero.data.remote

import com.sofia.superHero.features.superHero.domain.Biography
import com.sofia.superHero.features.superHero.domain.Hero
import com.sofia.superHero.features.superHero.domain.Work


fun HeroApiModel.toModel(): Hero =
    Hero(
        this.id,
        this.name,
        this.image.image,
        this.powerstats.intelligence,
        this.powerstats.strength,
        this.powerstats.speed,
        this.powerstats.durability,
        this.powerstats.power,
        this.powerstats.combat
    )

fun BiographyApiModel.toModel(id: String): Biography =
    Biography(id, this.fullName, this.alignment)


fun WorkApiModel.toModel(id: String): Work =
    Work(id, this.occupation)