package com.bouzajesus.cinetrack.presentation.details.recyclerview_setup

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.databinding.DetailRecyclerViewItemBinding
import com.bouzajesus.cinetrack.presentation.models.GenresModel

class DetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DetailRecyclerViewItemBinding.bind(view)

    fun render(genre: GenresModel) {

        binding.tvDetailGenre.text = ContextCompat.getString(itemView.context, genre.name)
        binding.ivDetailGenre.setImageResource(genre.image)
    }
}