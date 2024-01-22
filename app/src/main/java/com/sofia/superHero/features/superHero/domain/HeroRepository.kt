package com.sofia.superHero.features.superHero.domain

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp


interface HeroRepository {
    suspend fun findHeroes(): Either<ErrorApp, List<Hero>>
    suspend fun findHeroById(id: String): Either<ErrorApp, Hero>
}