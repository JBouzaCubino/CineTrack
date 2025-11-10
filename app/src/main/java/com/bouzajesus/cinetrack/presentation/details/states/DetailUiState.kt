package com.bouzajesus.cinetrack.presentation.details.states

import com.bouzajesus.cinetrack.domain.models.Media

sealed class DetailUiState {
    data object Loading: DetailUiState()
    data class Success(val media: Media): DetailUiState()
    data class Error(val message: String): DetailUiState()
}