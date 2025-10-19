package com.bouzajesus.cinetrack.ui.home

import androidx.lifecycle.ViewModel
import com.bouzajesus.cinetrack.data.remote.MediaApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(apiService: MediaApiService) : ViewModel() {

    private var _state = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state
}