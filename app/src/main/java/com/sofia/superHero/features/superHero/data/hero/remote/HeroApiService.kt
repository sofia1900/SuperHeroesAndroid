package com.sofia.superHero.features.superHero.data.hero.remote

import com.sofia.superHero.features.superHero.data.remote.HeroApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApiService {
    @GET("heroes.json")
    suspend fun findAllHeroes(): Response<List<HeroApiModel>>

    @GET("heroes/{idHero}.json")
    suspend fun findHeroById(@Path("idHero") idHero: String): Response<HeroApiModel>
}