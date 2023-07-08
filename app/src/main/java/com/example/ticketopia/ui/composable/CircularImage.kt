package com.example.ticketopia.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 7/8/2023.
 */
@Composable
fun CircularImage(painter: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = painter,
        contentDescription = "Circular Image",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(76.dp)
            .clip(CircleShape)
    )
}