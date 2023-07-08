package com.example.ticketopia.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketopia.R
import com.example.ticketopia.ui.theme.DarkGray

/**
 * Created by Aziza Helmy on 7/8/2023.
 */
@Composable
fun TextWithIconStart(text: String, modifier: Modifier = Modifier,painter: Painter) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = "Time Icon ",
            tint = DarkGray
        )
        Text(text = text)
    }
}