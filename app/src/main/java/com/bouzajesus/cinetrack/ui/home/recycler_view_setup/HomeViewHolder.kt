package com.bouzajesus.cinetrack.ui.home.recycler_view_setup

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.databinding.HomeRecyclerViewItemBinding
import com.bouzajesus.cinetrack.domain.models.Media
import com.bumptech.glide.Glide

class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: HomeRecyclerViewItemBinding = HomeRecyclerViewItemBinding.bind(view)

    fun render(show: Media) {

        binding.tvPrimaryTitle.text = show.primaryTitle

        Glide
            .with(itemView)
            .load(show.primaryImageUrl)
            .into(binding.ivShowRvItem)
    }
}