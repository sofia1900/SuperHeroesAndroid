package com.sofia.superHero.features.superHero.data.biography.local

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.domain.Biography

interface BiographyLocalDataSource {
    suspend fun saveBiography(biography: Biography): Either<ErrorApp, Boolean>
    suspend fun findBiographyById(id : String) : Either<ErrorApp, Biography>
}