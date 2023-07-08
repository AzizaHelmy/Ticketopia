package com.example.ticketopia.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.ticketopia.ui.theme.Orange
import com.example.ticketopia.ui.theme.White

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun IconWithCircularShape(
    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Icon(
        painter = painter,
        contentDescription = "Play Icon",
        modifier = modifier
            .clip(CircleShape)
            .background(Orange)
            .padding(12.dp)
            .clickable {
                onClick()
            },
        tint = White
    )
}
