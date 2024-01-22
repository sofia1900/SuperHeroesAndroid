package com.sofia.superHero.features.superHero.data.work.remote

import com.sofia.superHero.app.data.remote.apiCall
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.remote.toModel
import com.sofia.superHero.features.superHero.domain.Work
import javax.inject.Inject

class WorkApiRemoteDataSource @Inject constructor(private val apiService: WorkApiService) {
    suspend fun getOccupation(id: String): Either<ErrorApp, Work> {
        return apiCall {
            apiService.getOccupation(id)
        }.map { biographyApiModel ->
            biographyApiModel.toModel(id)
        }
    }
}