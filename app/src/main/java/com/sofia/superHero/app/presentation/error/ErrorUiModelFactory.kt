package com.sofia.superHero.app.presentation.error

import com.sofia.superHero.app.domain.ErrorApp

class ErrorUiModelFactory {
    fun create (errorApp: ErrorApp, onClick : (() -> Unit)? = null) : ErrorUiModel {
        return when (errorApp){
            ErrorApp.DataError -> DataErrorUiModel(onClick)
            ErrorApp.InternetError -> InternetErrorUiModel(onClick)
            ErrorApp.ServerError -> ServerErrorUiModel(onClick)
            else -> {
                UnknowErrorUiModel(onClick)
            }
        }
    }
}