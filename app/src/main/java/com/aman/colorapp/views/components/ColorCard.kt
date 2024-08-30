package com.aman.colorapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.colorapp.data.model.ColorEntity
import com.aman.colorapp.ui.theme.fontFamily

@Composable
fun ColorCard(colorEntity: ColorEntity) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(140.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(Modifier.fillMaxSize().
        background(color = Color(android.graphics.Color.parseColor(colorEntity.color)))) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = colorEntity.color,
                    fontFamily = fontFamily,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(5.dp))
                HorizontalDivider(modifier = Modifier.weight(0.2f), thickness = 1.dp, color = Color.White)
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.BottomEnd),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Created at",
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Text(
                    text = colorEntity.timestamp,
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}