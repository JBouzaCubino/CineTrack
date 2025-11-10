package com.bouzajesus.cinetrack.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.domain.usecases.GetShowByNameUseCase
import com.bouzajesus.cinetrack.domain.usecases.ShowAllShowsUseCase
import com.bouzajesus.cinetrack.presentation.home.states.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val showAllShowsUseCase: ShowAllShowsUseCase,
    private val getShowByNameUseCase: GetShowByNameUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state

    private var titleList: List<Media> = emptyList()

    fun getTitles() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                titleList = showAllShowsUseCase.execute()
                _state.value = HomeUiState.Success(titleList)
            }
            catch (e: IOException){
                _state.value = HomeUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun getShowByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = HomeUiState.Loading

            try {
                //If the searchView field is empty, the complete show list is showed
                //Otherwise, the query show list is showed
                if (name == "") {
                    _state.value = HomeUiState.Success(titleList)
                } else {
                    val list: List<Media> = getShowByNameUseCase.execute(name)
                    _state.value = HomeUiState.Success(list)
                }
            } catch (e: IOException) {
                _state.value = HomeUiState.Error(e.message ?: "Error desconocido")
            }


        }

    }
}