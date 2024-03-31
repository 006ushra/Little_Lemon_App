package com.bush.littlelemonapp.remote

import kotlinx.serialization.Serializable

@Serializable
data class HomeMenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float
)
