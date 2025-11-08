package com.bouzajesus.cinetrack.ui.details

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.bouzajesus.cinetrack.databinding.ActivityDetailBinding
import com.bouzajesus.cinetrack.ui.details.states.DetailUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        lifecycleScope.launch {
            detailViewModel.state.collect { state ->
                when(state){
                    is DetailUiState.Error -> initErrorState(state.message)
                    DetailUiState.Loading -> initLoadingState()
                    is DetailUiState.Success -> initSuccessState()
                }
            }
        }

    }

    private fun initErrorState(message: String) {
        binding.detailLoadingProgressBar.isVisible = false
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun initLoadingState(){
        binding.detailLoadingProgressBar.isVisible = true
    }

    private fun initSuccessState(){
        binding.detailLoadingProgressBar.isVisible = false
    }
}