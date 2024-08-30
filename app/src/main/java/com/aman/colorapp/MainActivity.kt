package com.aman.colorapp

import com.aman.colorapp.viewmodel.ColorViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.aman.colorapp.ui.theme.ColorAppTheme
import com.aman.colorapp.viewmodel.ColorViewModelFactory
import com.aman.colorapp.views.ListOfColorCards

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private lateinit var colorViewModel: ColorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ColorViewModelFactory(application)
        colorViewModel = ViewModelProvider(this,factory)[ColorViewModel::class.java]
        setContent {
            ColorAppTheme {
                ListOfColorCards(viewModel = colorViewModel)
            }
        }
    }
}

