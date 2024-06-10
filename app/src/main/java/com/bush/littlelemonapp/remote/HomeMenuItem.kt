package com.bush.littlelemonapp.remote

import com.bush.littlelemonapp.local.HomeMenuItemLocal
import kotlinx.serialization.Serializable

@Serializable
data class HomeMenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
) {
    fun convertToLocalItem() = HomeMenuItemLocal(
        id,
        title,
        description,
        price,
        image,
        category
    )
}
