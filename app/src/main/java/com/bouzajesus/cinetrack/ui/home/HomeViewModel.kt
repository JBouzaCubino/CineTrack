package com.bouzajesus.cinetrack.ui.home

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

@HiltViewModel
class HomeViewModel @Inject constructor(private val showAllShowsUseCase: ShowAllShowsUseCase) : ViewModel() {

    private var _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state

    fun getTitles() {
        viewModelScope.launch(Dispatchers.IO) {
            val titleList: List<Media> = showAllShowsUseCase.execute()

            //if the API response is successful and the object obtained is not null, success state
            //Otherwise, error state
            if (titleList.isEmpty()) {
                _state.value = HomeUiState.Error("Lista vacía")

            } else {
                _state.value = HomeUiState.Success(titleList)
            }
        }
    }
}