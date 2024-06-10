package com.bush.littlelemonapp.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HomeMenuItemLocal::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun menuItemDao(): HomeMenuItemDao
}