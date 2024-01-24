package com.sofia.superHero.features.superHero.data.biography.local.room

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.data.biography.local.BiographyLocalDataSource
import com.sofia.superHero.features.superHero.data.local.toEntity
import com.sofia.superHero.features.superHero.data.local.toModel
import com.sofia.superHero.features.superHero.domain.Biography
import javax.inject.Inject

class BiographyLocalDbDataSource @Inject constructor (private val biographyDao: BiographyDao) : BiographyLocalDataSource {

    override suspend fun saveBiography(biography: Biography): Either<ErrorApp, Boolean> {
        return try {
            biographyDao.insert(biography.toEntity())
            true.right()
        }catch (ex : Exception){
            ErrorApp.DataError.left()
        }
    }

    override suspend fun findBiographyById(id: String): Either<ErrorApp, Biography> {
        return try {
            val biography = biographyDao.getById(id)
            biography?.toModel()?.right() ?: ErrorApp.DataError.left()
        } catch (ex : Exception){
            ErrorApp.DataError.left()
        }
    }

}