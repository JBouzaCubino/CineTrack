package com.bouzajesus.cinetrack.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bouzajesus.cinetrack.domain.models.Category
import com.bouzajesus.cinetrack.domain.usecases.ShowAllCategoriesUseCase
import com.bouzajesus.cinetrack.ui.details.states.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val showAllCategoriesUseCase: ShowAllCategoriesUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<DetailUiState> = MutableStateFlow(DetailUiState.Loading)
    val state: StateFlow<DetailUiState> = _state

    fun getCategories() {
        viewModelScope.launch {
            val listCategory: List<Category> = showAllCategoriesUseCase.execute()

            try {
                if (listCategory.isEmpty()) _state.value = DetailUiState.Error("lista vacía")
                else _state.value = DetailUiState.Success(listCategory)
            } catch (e: IOException) {
                _state.value = DetailUiState.Error(e.message ?: "error desconocido")
            }
        }

    }
    
}