package com.aman.colorapp.viewmodel

import com.aman.colorapp.data.repository.ColorRepository
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.aman.colorapp.data.database.ColorDatabase
import com.aman.colorapp.data.model.ColorEntity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ColorViewModel(application: Application) : ViewModel() {

    private val colorDao = ColorDatabase.getDatabase(application).colorDao()
    private val repository: ColorRepository = ColorRepository(colorDao)

    val allColors: LiveData<List<ColorEntity>> = repository.allColors.asLiveData()
    val pendingCount: LiveData<Int> = repository.pendingCount

    fun addColor() {
        viewModelScope.launch {
            val newColor = ColorEntity(
                color = generateRandomColor(),
                timestamp = getCurrentFormattedTimestamp(),
                isSynced = false
            )
            repository.insertColor(newColor)
        }
    }

    fun syncColors() {
        viewModelScope.launch {
            val unsyncedColors = repository.getUnsyncedColors()
            for (color in unsyncedColors) {
                syncColorToFirebase(color)
            }
        }
    }

    private fun syncColorToFirebase(color: ColorEntity) {
        viewModelScope.launch {
            val unsyncedColors = repository.getUnsyncedColors()

            if (unsyncedColors.isNotEmpty()) {
                try {

                    val databaseRef = FirebaseDatabase.getInstance().getReference("colors")

                    unsyncedColors.forEach { color ->
                        val key = databaseRef.push().key ?: return@forEach
                        databaseRef.child(key).setValue(color)
                    }


                    repository.markColorsAsSynced(unsyncedColors.map { it.id })


                    Log.d("Sync", "Entries synced successfully to Firebase.")

                } catch (e: Exception) {
                    Log.e("SyncError", "Error syncing colors: ${e.message}")
                }
            }
        }
    }



    private fun generateRandomColor(): String {
        val random = java.util.Random()
        val color = String.format("#%06X", random.nextInt(0xFFFFFF + 1))
        return color
    }

    private fun getCurrentFormattedTimestamp(): String {
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
}

