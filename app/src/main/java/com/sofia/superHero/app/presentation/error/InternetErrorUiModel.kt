package com.sofia.superHero.app.presentation.error

import com.sofia.myapplication.R

class InternetErrorUiModel (private val onClick : (() -> Unit)? = null) : ErrorUiModel {
    override fun getImage(): Int = R.drawable.ic_error
    override fun getTitle(): Int = R.string.title_internet_error
    override fun getDescription(): Int = R.string.description_internet_error
    override fun onClickRetry(): (() -> Unit)? = onClick
}