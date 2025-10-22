package com.bouzajesus.cinetrack.ui.home

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.usecases.ShowAllShowsUseCase
import com.bouzajesus.cinetrack.ui.home.states.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

@HiltViewModel
class HomeViewModel @Inject constructor(private val showAllShowsUseCase: ShowAllShowsUseCase) : ViewModel() {

    private var _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state

    fun getTitles() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val titleList: List<Media> = showAllShowsUseCase.execute()
                _state.value = HomeUiState.Success(titleList)
            }
            catch (e: IOException){
                _state.value = HomeUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}