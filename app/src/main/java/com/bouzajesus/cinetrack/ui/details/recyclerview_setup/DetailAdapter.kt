package com.bouzajesus.cinetrack.ui.details.recyclerview_setup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.ui.models.GenresModel

class DetailAdapter(private var list: List<GenresModel> = emptyList()): RecyclerView.Adapter<DetailViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_recycler_view_item, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DetailViewHolder,
        position: Int
    ) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateList(newList: List<GenresModel>){
        this.list = newList
    }
}