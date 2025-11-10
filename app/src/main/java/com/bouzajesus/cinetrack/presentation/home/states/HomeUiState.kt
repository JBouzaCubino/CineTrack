package com.bouzajesus.cinetrack.presentation.home.states

import com.bouzajesus.cinetrack.domain.models.Media

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val mediaItemList: List<Media>): HomeUiState()
    data class Error(val message: String): HomeUiState()
}