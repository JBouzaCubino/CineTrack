package com.bouzajesus.cinetrack.ui.home.recycler_view_setup

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.data.remote.MediaItem
import com.bouzajesus.cinetrack.databinding.HomeRecyclerViewItemBinding

class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: HomeRecyclerViewItemBinding = HomeRecyclerViewItemBinding.bind(view)

    fun render(show: MediaItem){

        binding.tvPrimaryTitle.text = show.primaryTitle
    }
}