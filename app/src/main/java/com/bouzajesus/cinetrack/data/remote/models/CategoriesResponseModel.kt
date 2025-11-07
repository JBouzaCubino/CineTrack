package com.bouzajesus.cinetrack.data.remote.models

import com.bouzajesus.cinetrack.domain.models.Category
import com.google.gson.annotations.SerializedName

data class CategoriesResponseModel(
    @SerializedName("categories") val categories: List<CategoryItem>
){
    fun toDomain(): List<Category>{

        return this.categories.map {
            Category(
                it.category
            )
        }
    }
}

data class CategoryItem(
    @SerializedName("category") val category: String,
    @SerializedName("interests") val interests: List<InterestItem>
)

data class InterestItem(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)
