package com.sofia.superHero.features.superHero.presentation.listHeroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.presentation.error.ErrorUiModel
import com.sofia.superHero.app.presentation.error.toErrorUi
import com.sofia.superHero.features.superHero.domain.GetSuperHeroesUseCase
import com.sofia.superHero.features.superHero.domain.SuperHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(private val getSuperHeroesUseCase: GetSuperHeroesUseCase) :
    ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadListSuperHeroes() {
        _uiState.value = UiState(isLoading = true)
        executeUseCase()
    }

    fun refreshList () {
        executeUseCase()
    }

    private fun executeUseCase () {
        viewModelScope.launch(Dispatchers.IO) {
            getSuperHeroesUseCase().fold(
                { responseError(it) },
                { responseSuccess(it) }
            )
        }
    }

    private fun responseError(error: ErrorApp) {
        _uiState.postValue(UiState(error = error.toErrorUi {
            loadListSuperHeroes()
        }))
    }

    private fun responseSuccess(listHeroes: List<SuperHero>) {
        _uiState.postValue(UiState(superHeroes = listHeroes))
    }

    data class UiState(
        val error: ErrorUiModel? = null,
        val isLoading: Boolean = false,
        val superHeroes: List<SuperHero>? = null
    )
}