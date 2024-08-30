package com.aman.colorapp.data.repository

import androidx.lifecycle.LiveData
import com.aman.colorapp.data.dao.ColorDao
import com.aman.colorapp.data.model.ColorEntity
import kotlinx.coroutines.flow.Flow


class ColorRepository(private val colorDao: ColorDao) {

    val allColors: Flow<List<ColorEntity>> = colorDao.getAllColors()
    val pendingCount: LiveData<Int> = colorDao.getPendingCount()

    suspend fun insertColor(color: ColorEntity) {
        colorDao.insertColor(color)
    }

    suspend fun getUnsyncedColors(): List<ColorEntity> {
        return colorDao.getUnsyncedColors()
    }

    suspend fun markColorsAsSynced(ids: List<Int>) {
        colorDao.markColorsAsSynced(ids)
    }
}
