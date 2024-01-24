package com.sofia.superHero.features.superHero.data.work.local

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.domain.Work

interface WorkLocalDataSource {
    suspend fun findWorkById(id: String): Either<ErrorApp, Work>

    suspend fun saveWork(work: Work): Either<ErrorApp, Boolean>
}