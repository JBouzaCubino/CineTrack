package com.bouzajesus.cinetrack.ui.home.states

import com.bouzajesus.cinetrack.data.remote.MediaItem

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val mediaItemList: List<MediaItem>): HomeUiState()
    data class Error(val message: String): HomeUiState()
}