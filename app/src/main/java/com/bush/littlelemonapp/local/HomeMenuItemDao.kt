package com.bush.littlelemonapp.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HomeMenuItemDao {
    @Insert
    fun insertAll(manuItems: List<HomeMenuItemLocal>)

    @Query("SELECT (SELECT COUNT(*) FROM HomeMenuItemLocal) == 0")
    fun isEmpty(): Boolean

    @Query("SELECT * FROM HomeMenuItemLocal")
    fun getAll(): LiveData<List<HomeMenuItemLocal>>

    @Query("SELECT * FROM HomeMenuItemLocal WHERE id = :userId")
    fun getDish(userId: Int): LiveData<HomeMenuItemLocal>
}