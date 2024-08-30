package com.aman.colorapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.colorapp.R
import com.aman.colorapp.ui.theme.Primary
import com.aman.colorapp.ui.theme.Secondary
import com.aman.colorapp.ui.theme.fontFamily

@Composable
fun TopBarSyncButton(onSyncButtonClicked:() -> Unit, pendingEntries: String) {
    Card (modifier = Modifier
        .width(56.dp)
        .height(32.dp)
        .clip(RoundedCornerShape(15.dp))){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Secondary),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = pendingEntries,
                fontFamily = fontFamily,
                fontSize = 14.sp,
                color = Color.White
            )


            IconButton(
                onClick = onSyncButtonClicked
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sync),
                    modifier= Modifier.size(24.dp),
                    contentDescription = "Sync Entries",
                    tint= Primary
                )
            }
        }
    }
}


