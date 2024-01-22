package com.sofia.superHero.features.superHero.data.biography

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.biography.local.BiographyLocalDataSource
import com.sofia.superHero.features.superHero.data.biography.remote.BiographyApiRemoteDataSource
import com.sofia.superHero.features.superHero.domain.Biography
import com.sofia.superHero.features.superHero.domain.BiographyRepository
import javax.inject.Inject

class BiographyDataRepository @Inject constructor(
    private val localData: BiographyLocalDataSource,
    private val apiRemoteData: BiographyApiRemoteDataSource
) :
    BiographyRepository {
    override suspend fun getBiography(id: String): Either<ErrorApp, Biography> {
        val local = localData.findBiographyById(id)
        return if (local.isRight() && local.get().id != null) local
        else {
            apiRemoteData.getFullName(id).map {
                localData.saveBiography(it)
                it
            }
        }
    }
}