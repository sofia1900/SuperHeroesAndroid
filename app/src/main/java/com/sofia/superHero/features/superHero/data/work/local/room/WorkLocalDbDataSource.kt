package com.sofia.superHero.features.superHero.data.work.local.room

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.data.local.toEntity
import com.sofia.superHero.features.superHero.data.local.toModel
import com.sofia.superHero.features.superHero.data.work.local.WorkLocalDataSource
import com.sofia.superHero.features.superHero.domain.Work
import javax.inject.Inject

class WorkLocalDbDataSource @Inject constructor(private val workDao: WorkDao) :
    WorkLocalDataSource {
    override suspend fun findWorkById(id: String): Either<ErrorApp, Work> {
        return try {
            val biography = workDao.getById(id)
            biography?.toModel()?.right() ?: ErrorApp.DataError.left()
        } catch (ex: Exception) {
            ErrorApp.DataError.left()
        }
    }

    override suspend fun saveWork(work: Work): Either<ErrorApp, Boolean> {
        return try {
            workDao.insert(work.toEntity())
            true.right()
        } catch (ex: Exception) {
            ErrorApp.DataError.left()
        }
    }
}