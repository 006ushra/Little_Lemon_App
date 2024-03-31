package com.bush.littlelemonapp.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HomeMenuItemDao {
    @Insert
    fun insertAll(manuItems: List<HomeMenuItemLocal>)

    @Query("SELECT (SELECT COUNT(*) FROM HomeMenuItemLocal) == 0")
    fun isEmpty(): Boolean
}