package com.bush.littlelemonapp.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeMenuItemLocal(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val price: Float
)
