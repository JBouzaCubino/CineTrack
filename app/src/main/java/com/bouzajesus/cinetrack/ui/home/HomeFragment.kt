package com.bouzajesus.cinetrack.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bouzajesus.cinetrack.databinding.FragmentHomeBinding
import com.bouzajesus.cinetrack.domain.models.Media
import com.bouzajesus.cinetrack.ui.home.recyclerview_setup.HomeAdapter
import com.bouzajesus.cinetrack.ui.home.states.HomeUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //ViewBinding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private val homeViewModel: HomeViewModel by viewModels()

    //Adapter
    private lateinit var adapter: HomeAdapter

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

    }

    private fun showTitles() {
        homeViewModel.getTitles()
    }

    private fun initUI() {

        initViewModelCollector()
        showTitles()
        initSearchView()
    }

    private fun initViewModelCollector() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
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
    }

    private fun initSearchView() {
        binding.searchViewHome.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(name: String?): Boolean {
                homeViewModel.getShowByName(name ?: "")
                return true
            }

            override fun onQueryTextSubmit(name: String?): Boolean {
                homeViewModel.getShowByName(name ?: "")
                return false
            }

        })
    }

    private fun initSuccessState(mediaItemList: List<Media>) {
        binding.homeLoadingProgressBar.isVisible = false
        adapter.updateList(mediaItemList)
    }

    private fun initLoadingState() {
        binding.homeLoadingProgressBar.isVisible = true
    }

    private fun initErrorState(message: String) {
        binding.homeLoadingProgressBar.isVisible = false
        adapter.updateList(emptyList())
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {

        initAdapter()
        binding.recyclerViewHome.adapter = adapter
        binding.recyclerViewHome.layoutManager = GridLayoutManager(this.context, 2)
    }

    private fun initAdapter() {
        adapter = HomeAdapter { media ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(media.id)
            findNavController().navigate(action)
        }
    }

}