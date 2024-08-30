package com.aman.colorapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aman.colorapp.data.model.ColorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Query("SELECT * FROM color_table")
    fun getAllColors(): Flow<List<ColorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: ColorEntity)

    @Query("SELECT COUNT(*) FROM color_table WHERE isSynced = 0")
    fun getPendingCount(): LiveData<Int>

    @Query("SELECT * FROM color_table WHERE isSynced = 0")
    suspend fun getUnsyncedColors(): List<ColorEntity>

    @Update
    suspend fun updateColor(color: ColorEntity)

    @Query("UPDATE color_table SET isSynced = 1 WHERE id IN (:ids)")
    suspend fun markColorsAsSynced(ids: List<Int>)
}

