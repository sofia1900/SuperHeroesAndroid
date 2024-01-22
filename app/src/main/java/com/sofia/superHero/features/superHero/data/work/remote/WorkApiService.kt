package com.sofia.superHero.features.superHero.data.work.remote

import com.sofia.superHero.features.superHero.data.remote.WorkApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WorkApiService {
    @GET("work/{idHero}.json")
    suspend fun getOccupation(@Path("idHero") idHero: String): Response<WorkApiModel>
}