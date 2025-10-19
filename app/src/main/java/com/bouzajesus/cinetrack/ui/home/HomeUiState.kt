package com.bouzajesus.cinetrack.ui.home

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val message: String): HomeUiState()
    data class Error(val message: String): HomeUiState()
}