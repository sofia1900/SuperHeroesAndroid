package com.sofia.superHero.features.superHero.data.hero.local

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.domain.Hero

interface HeroLocalDataSource {
    suspend fun findAllHeroes(): Either<ErrorApp, List<Hero>>

    suspend fun findHeroById(id: String): Either<ErrorApp, Hero>

    suspend fun saveSuperHero(superHero: Hero): Either<ErrorApp, Boolean>
}