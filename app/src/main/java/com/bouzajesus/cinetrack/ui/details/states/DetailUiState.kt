package com.bouzajesus.cinetrack.ui.details.states

import com.bouzajesus.cinetrack.domain.models.Category

sealed class DetailUiState {
    data object Loading: DetailUiState()
    data class Success(val categoryList: List<Category>): DetailUiState()
    data class Error(val message: String): DetailUiState()
}