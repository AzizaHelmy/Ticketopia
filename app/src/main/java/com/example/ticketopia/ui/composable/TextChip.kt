package com.example.ticketopia.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketopia.ui.theme.DarkGray
import com.example.ticketopia.ui.theme.White

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@Composable
fun TextChip(
    @DrawableRes iconId: Int?,
    tintColor: Color,
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray
) {
    val shape = CircleShape
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else LightGray,
                shape = shape
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = shape
            )
            .clip(shape = shape)
//            .clickable {
//                onChecked(!isSelected)
//            }
            .padding(4.dp)
    ) {
        iconId?.let { painterResource(id = it) }?.let {
            Icon(
                painter = it,
                tint = if (isSelected) White else tintColor,
                contentDescription = null
            )
        }
        Text(
            text = text,
            color = selectedColor,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
    }
}