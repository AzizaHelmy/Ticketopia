package com.example.ticketopia.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ticketopia.ui.theme.Gray
import com.example.ticketopia.ui.theme.TransGray

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun TimeItem(time: String) {
    Text(
        text = time,
        modifier = Modifier
            .border(
                border = BorderStroke(1.dp, TransGray),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 8.dp, vertical = 6.dp)
    )
}
