package com.sofia.superHero.features.superHero.data.hero.remote

import com.sofia.superHero.app.data.remote.apiCall
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.remote.toModel
import com.sofia.superHero.features.superHero.domain.Hero
import javax.inject.Inject

class HeroApiRemoteDataSource @Inject constructor(private val apiService: HeroApiService) {
    suspend fun findAllSuperHeroes(): Either<ErrorApp, List<Hero>> {
        return apiCall {
            apiService.findAllHeroes()
        }.map { heroesApiModel ->
            heroesApiModel.map { heroApiModel ->
                heroApiModel.toModel()
            }
        }
    }

    suspend fun findHeroById(id: String): Either<ErrorApp, Hero> {
        return apiCall {
            apiService.findHeroById(id)
        }.map { heroApiModel ->
            heroApiModel.toModel()
        }
    }
}