package com.bouzajesus.cinetrack.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bouzajesus.cinetrack.databinding.FragmentHomeBinding
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.ui.home.recycler_view_setup.HomeAdapter
import com.bouzajesus.cinetrack.ui.home.states.HomeUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //ViewBinding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private val homeViewModel: HomeViewModel by viewModels()

    //Adapter
    @Inject
    lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initUI()
        initState()
    }

    private fun initState() {
        homeViewModel.getTitles()
    }

    private fun initUI() {

        lifecycleScope.launch {
            homeViewModel.state.collect { state ->
                when (state) {
                    is HomeUiState.Error -> initErrorState(state.message)
                    HomeUiState.Loading -> initLoadingState()
                    is HomeUiState.Success -> {
                        initSuccessState(state.mediaItemList)
                    }
                }
            }
        }
    }

    private fun initSuccessState(mediaItemList: List<Media>) {
        binding.loadingProgressBar.isVisible = false
        adapter.updateList(mediaItemList)
    }

    private fun initLoadingState() {
        binding.loadingProgressBar.isVisible = true
    }

    private fun initErrorState(message: String) {
        binding.loadingProgressBar.isVisible = false
        adapter.updateList(emptyList())
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {

        binding.recyclerViewHome.adapter = adapter
        binding.recyclerViewHome.layoutManager = GridLayoutManager(this.context, 2)
    }

}