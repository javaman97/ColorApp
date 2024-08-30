package com.aman.colorapp.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.colorapp.ui.theme.Primary
import com.aman.colorapp.ui.theme.Secondary
import com.aman.colorapp.ui.theme.fontFamily

@Composable
fun AddColorExtendedFAB(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        containerColor = Secondary,
        content = {
            Row(
                modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(15.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = text, fontFamily = fontFamily, fontSize = 18.sp, color = Primary)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = icon,
                    contentDescription = "Add Color",
                    modifier= Modifier.size(24.dp),
                    tint = Primary
                )
            }
        }
    )
}


