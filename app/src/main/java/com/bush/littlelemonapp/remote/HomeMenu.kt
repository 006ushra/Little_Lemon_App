package com.bush.littlelemonapp.remote

import kotlinx.serialization.Serializable

@Serializable
data class HomeMenu(
    val menu: List<HomeMenuItem>
)
