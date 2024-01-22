package com.sofia.superHero.features.superHero.domain

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp


interface WorkRepository {
    suspend fun getWork(id: String): Either<ErrorApp, Work>
}