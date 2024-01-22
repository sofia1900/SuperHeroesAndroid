package com.sofia.superHero.features.superHero.presentation.detailHero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.presentation.error.ErrorUiModel
import com.sofia.superHero.app.presentation.error.toErrorUi
import com.sofia.superHero.features.superHero.domain.GetSuperHeroByIdUseCase
import com.sofia.superHero.features.superHero.domain.SuperHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(private val getSuperHeroByIdUseCase: GetSuperHeroByIdUseCase) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> get () = _uiState

    fun loadDetails (id : String){
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO){
            getSuperHeroByIdUseCase(id).fold(
                {responseError(it, id)},
                {responseSucess(it)}
            )
        }
    }

    private fun responseError(error : ErrorApp, id: String){
        _uiState.postValue(UiState(error = error.toErrorUi {
            loadDetails(id)
        }))
    }

    private fun responseSucess (superHero : SuperHero){
        _uiState.postValue(UiState(superHero = superHero))
    }

    data class UiState (
        val error : ErrorUiModel? = null,
        val isLoading : Boolean = false,
        val superHero : SuperHero? = null
    )

}