package com.sofia.superHero.features.superHero.domain

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp


interface BiographyRepository {
    suspend fun getBiography(id: String): Either<ErrorApp, Biography>
}