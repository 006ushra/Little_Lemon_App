package com.bush.littlelemonapp.remote

import com.bush.littlelemonapp.local.HomeMenuItemLocal
import kotlinx.serialization.Serializable

@Serializable
data class HomeMenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float
) {
    fun convertToLocalItem() = HomeMenuItemLocal(
        id,
        name,
        description,
        price
    )
}
