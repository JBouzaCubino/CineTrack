package com.bouzajesus.cinetrack.ui.home.recycler_view_setup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.data.remote.MediaItem

class HomeAdapter(private var mediaList: List<MediaItem>): RecyclerView.Adapter<HomeViewHolder>() {
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
        holder.render(mediaList[position])
    }

    override fun getItemCount(): Int = mediaList.size

    fun updateList(newList: List<MediaItem>){
        mediaList = newList
        notifyDataSetChanged()
    }
}