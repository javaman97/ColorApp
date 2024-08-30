package com.aman.colorapp.views.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.aman.colorapp.ui.theme.Primary
import com.aman.colorapp.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorScreenTopAppBar(
    onSyncButtonClicked:() ->Unit,
    pendingEntries:String
) {
    TopAppBar(
        title = {
            Text(
                text = "Color App",
                color = Color.White,
                fontFamily = fontFamily
            )
        },
        actions = {

         TopBarSyncButton(onSyncButtonClicked,pendingEntries)

        },
       colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Primary))
}