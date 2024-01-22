package com.sofia.superHero.features.superHero.domain

data class Hero(
    val id: String,
    val name: String,
    val image: String,
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Biography(val id: String, val fullName: String, val alignment: String)

data class Work(val id: String, val occupation: String)