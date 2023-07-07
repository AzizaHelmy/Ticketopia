package com.example.ticketopia.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketopia.ui.theme.Adamina

/**
 * Created by Aziza Helmy on 7/5/2023.
 */


@Composable
fun TextHeader(text: String) {
    Text(
        text = text,
//        fontFamily = Adamina,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 32.dp, end = 32.dp)
    )
}