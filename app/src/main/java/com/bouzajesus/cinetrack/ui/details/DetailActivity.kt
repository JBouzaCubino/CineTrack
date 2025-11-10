package com.bouzajesus.cinetrack.ui.details

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bouzajesus.cinetrack.databinding.ActivityDetailBinding
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.ui.details.recyclerview_setup.DetailAdapter
import com.bouzajesus.cinetrack.ui.details.states.DetailUiState
import com.bouzajesus.cinetrack.ui.mappers.GenresToGenresModelMapper
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    //ViewModel
    private val detailViewModel by viewModels<DetailViewModel>()

    //SafeArgs
    private val args: DetailActivityArgs by navArgs()

    //Adapter
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.fabBack.setOnClickListener { finish() }

        binding.btnFavouritesDetails.setOnClickListener {

        }
    }

    private fun initUI() {

        detailViewModel.getShowById(args.mediaId)

        initRecyclerView()

        lifecycleScope.launch {
            detailViewModel.state.collect { state ->
                when(state){
                    is DetailUiState.Error -> initErrorState(state.message)
                    DetailUiState.Loading -> initLoadingState()
                    is DetailUiState.Success -> initSuccessState(state.media)
                }
            }
        }

    }

    private fun initRecyclerView() {
        binding.rvDetailGenres.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = DetailAdapter()
        binding.rvDetailGenres.adapter = adapter
    }

    private fun initErrorState(message: String) {
        adapter.updateList(emptyList())
        binding.detailLoadingProgressBar.isVisible = false
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun initLoadingState(){
        binding.detailLoadingProgressBar.isVisible = true
    }

    private fun initSuccessState(media: Media) {
        val genresModelList = GenresToGenresModelMapper.mapGenresToGenresModel(media)
        adapter.updateList(genresModelList)
        binding.rvDetailGenres.adapter = adapter
        binding.detailLoadingProgressBar.isVisible = false

        Glide
            .with(this)
            .load(media.primaryImageUrl)
            .into(binding.ivPrimaryImageDetail)

        binding.tvPrimaryTitleCardViewDetails.text = media.primaryTitle

        binding.tvPlotCardViewDetails.text = media.plot
    }
}