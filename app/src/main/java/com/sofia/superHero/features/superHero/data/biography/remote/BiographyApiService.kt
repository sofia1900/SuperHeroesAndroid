package com.sofia.superHero.features.superHero.data.biography.remote

import com.sofia.superHero.features.superHero.data.remote.BiographyApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BiographyApiService {
    @GET("biography/{idHero}.json")
    suspend fun getFullName(@Path("idHero") idHero: String): Response<BiographyApiModel>
}