package com.bouzajesus.cinetrack.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.cinetrack.data.remote.Media
import com.bouzajesus.cinetrack.data.remote.MediaApiService
import com.bouzajesus.cinetrack.ui.home.states.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiService: MediaApiService) : ViewModel() {

    private var _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state

    fun getTitles() {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Media> = apiService.getTitles()

            val mediaObject: Media? = response.body()

            //if the API response is successful and the object obtained is not null, success state
            //Otherwise, error state
            if (response.isSuccessful && mediaObject != null) {
                _state.value = HomeUiState.Success(mediaObject.titles)
            } else {
                _state.value = HomeUiState.Error(response.message())
            }
        }
    }
}