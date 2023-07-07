package com.example.ticketopia.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketopia.R
import com.example.ticketopia.ui.theme.TransGray
import com.example.ticketopia.ui.theme.White

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun ExitIcon(modifier: Modifier=Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.icon_exit),
        contentDescription = "",
        modifier = modifier
            .clip(shape = CircleShape)
            .background(TransGray)
            .padding(4.dp),
        tint = White,

        )
}