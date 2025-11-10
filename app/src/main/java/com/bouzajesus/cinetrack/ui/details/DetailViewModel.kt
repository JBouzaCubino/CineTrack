package com.bouzajesus.cinetrack.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.cinetrack.domain.usecases.GetShowByIdUseCase
import com.bouzajesus.cinetrack.ui.details.states.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getShowByIdUseCase: GetShowByIdUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<DetailUiState> = MutableStateFlow(DetailUiState.Loading)
    val state: StateFlow<DetailUiState> = _state

    fun getShowById(showId: String){
        viewModelScope.launch {
            val media = getShowByIdUseCase.execute(showId)

            try {

                _state.value = DetailUiState.Success(media)

            } catch (e: IOException) {
                _state.value = DetailUiState.Error(e.message ?: "error desconocido")
            } catch (e: NoSuchElementException){
                _state.value = DetailUiState.Error(e.message ?: "error desconocido")
            }
        }
    }
    
}