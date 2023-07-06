package com.example.ticketopia.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by Aziza Helmy on 7/6/2023.
 */
@Composable
fun MovieGenres() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextChip(iconId = null,
            tintColor = Color.Red,
            isSelected = false,
            text = "Fantasy",
            selectedColor = Color.DarkGray,
            onChecked = {})

        TextChip(iconId = null,
            tintColor = Color.Red,
            isSelected = false,
            text = "Adventure",
            selectedColor = Color.DarkGray,
            onChecked = {})
    }
}