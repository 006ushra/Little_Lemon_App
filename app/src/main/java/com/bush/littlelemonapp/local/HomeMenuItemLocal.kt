package com.bush.littlelemonapp.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeMenuItemLocal(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
)
