package com.aman.colorapp.views

import com.aman.colorapp.viewmodel.ColorViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.aman.colorapp.R
import com.aman.colorapp.views.components.AddColorExtendedFAB
import com.aman.colorapp.views.components.ColorCard
import com.aman.colorapp.views.components.ColorScreenTopAppBar


@Composable
fun ListOfColorCards(viewModel: ColorViewModel) {
    val allColors by viewModel.allColors.observeAsState(emptyList())
    val pendingCount by viewModel.pendingCount.observeAsState(0)

    Scaffold(topBar = {
        ColorScreenTopAppBar(
            onSyncButtonClicked = { viewModel.syncColors() },
            pendingEntries = pendingCount.toString()
        )
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
             LazyVerticalGrid(
                 columns = GridCells.Fixed(2),
                 verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(allColors) { item ->
                        ColorCard(item)
                    }

                }
            AddColorExtendedFAB(
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding( 15.dp).
                clip(RoundedCornerShape(8.dp)),
                "Add Color",
                ImageVector.vectorResource(id = R.drawable.add),
                onClick = { viewModel.addColor() }
            )
        }
    }
}