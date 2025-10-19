package com.bouzajesus.cinetrack.ui.home.states

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val message: String): HomeUiState()
    data class Error(val message: String): HomeUiState()
}