package com.example.ticketopia.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketopia.ui.theme.Orange
import com.example.ticketopia.ui.util.clickableIf

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@Composable
fun TextChip(
    text: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = false,
    selectedBorderColor: Color = Orange,
    unSelectedBorderColor: Color = LightGray,
    backgroundColor: Color = Orange,
    selectedTextColor: Color = White,
    unSelectedTextColor: Color = Gray,
    doWhenClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int? = null,
) {
    val shape = CircleShape

    Row(
        modifier = modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp,
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedBorderColor else unSelectedBorderColor,
                shape = shape
            )
            .background(
                color = if (isSelected) backgroundColor else Transparent,
                shape = shape
            )
            .clip(shape = shape)
            .clickableIf(condition = { isEnabled }) {
                doWhenClick
            }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconId?.let { painterResource(id = it) }?.let {
            Icon(
                painter = it,
                tint = if (isSelected) White else com.example.ticketopia.ui.theme.Gray,
                contentDescription = null, modifier = Modifier.size(18.dp)
            )
        }
        val textColor = if (isSelected) selectedTextColor else unSelectedTextColor
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(start = 6.dp, end = 6.dp)
        )
    }
}