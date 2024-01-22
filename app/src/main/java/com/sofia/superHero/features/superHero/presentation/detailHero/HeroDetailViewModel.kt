package com.sofia.superHero.features.superHero.presentation.detailHero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sofia.superHero.app.domain.ErrorApp
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
                {responseError(it)},
                {responseSucess(it)}
            )
        }
    }

    private fun responseError(error : ErrorApp){
        _uiState.postValue(UiState(errorApp = error))
    }

    private fun responseSucess (superHero : SuperHero){
        _uiState.postValue(UiState(superHero = superHero))
    }

    data class UiState (
        val errorApp : ErrorApp? = null,
        val isLoading : Boolean = false,
        val superHero : SuperHero? = null
    )

}