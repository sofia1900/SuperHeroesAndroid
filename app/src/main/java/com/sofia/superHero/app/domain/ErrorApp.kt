package com.sofia.superHero.app.domain

sealed class ErrorApp {
    object UnknownError : ErrorApp()
    object InternetError : ErrorApp()
    object DataError : ErrorApp()
    object ServerError : ErrorApp()
}