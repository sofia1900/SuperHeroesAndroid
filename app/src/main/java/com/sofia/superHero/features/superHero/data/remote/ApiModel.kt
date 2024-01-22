package com.sofia.superHero.features.superHero.data.remote

import com.google.gson.annotations.SerializedName

data class HeroApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("images") val image: ImagesApiModel,
    @SerializedName("powerstats") val powerstats: Powerstats,
)

data class ImagesApiModel(
    @SerializedName("sm") val image: String
)

data class Powerstats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class WorkApiModel(@SerializedName("occupation") val occupation: String)
data class BiographyApiModel(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("alignment") val alignment: String
)