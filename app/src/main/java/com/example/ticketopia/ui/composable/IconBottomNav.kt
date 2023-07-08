package com.example.ticketopia.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.example.ticketopia.ui.theme.White

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun IconBottomNav(painter: Painter, modifier: Modifier = Modifier, onClick: () -> Unit={}) {
    Icon(
        painter = painter,
        contentDescription = "Icon",
        modifier = modifier
            .clickable { onClick },
        tint = Color.Black
    )
}