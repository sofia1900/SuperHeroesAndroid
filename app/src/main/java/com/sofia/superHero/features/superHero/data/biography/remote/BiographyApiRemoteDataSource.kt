package com.sofia.superHero.features.superHero.data.biography.remote

import com.sofia.superHero.app.data.remote.apiCall
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.remote.toModel
import com.sofia.superHero.features.superHero.domain.Biography
import javax.inject.Inject

class BiographyApiRemoteDataSource @Inject constructor(private val apiService: BiographyApiService) {

    suspend fun getFullName(id: String): Either<ErrorApp, Biography> {
        return apiCall {
            apiService.getFullName(id)
        }.map { biographyApiModel ->
            biographyApiModel.toModel(id)
        }
    }

}