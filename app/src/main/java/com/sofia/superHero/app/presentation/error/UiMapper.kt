package com.sofia.superHero.app.presentation.error

import com.sofia.superHero.app.domain.ErrorApp

fun ErrorApp.toErrorUi(onClickRetry: (() -> Unit)? = null): ErrorUiModel {
    return ErrorUiModelFactory().create(this, onClickRetry)
}