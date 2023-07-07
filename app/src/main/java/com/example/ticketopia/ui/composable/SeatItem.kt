package com.example.ticketopia.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ticketopia.R
import com.example.ticketopia.ui.theme.Gray
import com.example.ticketopia.ui.theme.Orange

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun SeatItem(
    startIconColor: Color = Color.White,
    endIconColor: Color = Orange,
    containerColor: Color = Gray,
    rotateDegree: Float = 0f
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.rotate(rotateDegree)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = "container",
            tint = containerColor
        )
        Row(
            Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.seat2),
                contentDescription = "Seat",
                tint = startIconColor
            )
            Icon(
                painter = painterResource(id = R.drawable.seat2),
                contentDescription = "Seat",
                tint = endIconColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewSeatItem() {
    SeatItem()
}