package com.bouzajesus.cinetrack.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.doOnLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.databinding.FragmentDetailBinding
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.presentation.details.recyclerview_setup.DetailAdapter
import com.bouzajesus.cinetrack.presentation.details.states.DetailUiState
import com.bouzajesus.cinetrack.presentation.mappers.GenresToGenresModelMapper
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private val detailViewModel by viewModels<DetailViewModel>()

    //SafeArgs
    private val args: DetailActivityArgs by navArgs()

    //Adapter
    private lateinit var adapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.fabBack.setOnClickListener { goBackToHomeFragment() }

        binding.btnFavouritesDetails.setOnClickListener {

        }
    }

    private fun goBackToHomeFragment() {
        findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
    }

    private fun initUI() {

        detailViewModel.getShowById(args.mediaId)

        initRecyclerView()

        lifecycleScope.launch {
            detailViewModel.state.collect { state ->
                when (state) {
                    is DetailUiState.Error -> initErrorState(state.message)
                    DetailUiState.Loading -> initLoadingState()
                    is DetailUiState.Success -> initSuccessState(state.media)
                }
            }
        }

    }

    private fun initRecyclerView() {
        binding.rvDetailGenres.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = DetailAdapter()
        binding.rvDetailGenres.adapter = adapter
    }

    private fun initErrorState(message: String) {
        adapter.updateList(emptyList())
        binding.detailLoadingProgressBar.isVisible = false
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun initLoadingState() {
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

        binding.ratingDetails.rating = media.rating

        //Behavior's height = layoutFirstShowInfo's height (after rendering text)
        binding.layoutFirstShowInfo.doOnLayout { view ->
            val behavior = BottomSheetBehavior.from<CardView>(binding.cvShowDetails)
            behavior.peekHeight = view.height
        }
    }

}