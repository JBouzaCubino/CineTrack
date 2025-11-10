package com.bouzajesus.cinetrack.presentation.home.recyclerview_setup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.domain.models.Media

class HomeAdapter (private var mediaList: List<Media> = emptyList(), private val onItemClick: (media: Media) -> Unit) :
    RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_view_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HomeViewHolder,
        position: Int
    ) {
        holder.render(mediaList[position], onItemClick)
    }

    override fun getItemCount(): Int = mediaList.size

    fun updateList(newList: List<Media>){
        mediaList = newList
        notifyDataSetChanged()
    }
}