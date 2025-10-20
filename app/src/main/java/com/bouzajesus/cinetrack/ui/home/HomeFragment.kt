package com.bouzajesus.cinetrack.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bouzajesus.cinetrack.databinding.FragmentHomeBinding
import com.bouzajesus.cinetrack.ui.home.recycler_view_setup.HomeAdapter
import com.bouzajesus.cinetrack.ui.home.states.HomeUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //ViewBinding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initState()
        initRecyclerView()
    }

    private fun initState() {
        homeViewModel.changeState()
    }

    private fun initUI() {
        when (homeViewModel.state.value) {
            is HomeUiState.Error -> initErrorState()
            HomeUiState.Loading -> initLoadingState()
            is HomeUiState.Success -> initSuccessState()
        }
    }

    private fun initSuccessState() {
        TODO("Not yet implemented")
    }

    private fun initLoadingState() {
        TODO("Not yet implemented")
    }

    private fun initErrorState() {
        TODO("Not yet implemented")
    }

    private fun initRecyclerView() {

        binding.recyclerViewHome.adapter = HomeAdapter()
        binding.recyclerViewHome.layoutManager = LinearLayoutManager(this.context)
    }

}