package com.example.ticketopia.ui.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketopia.ui.theme.TransGray
import com.example.ticketopia.ui.theme.White
import com.example.ticketopia.ui.viewmodel.state.CalenderUiState

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun CalenderItem(calenderUiState: CalenderUiState) {
    Card(
        modifier = Modifier
            .height(60.dp)
            .width(50.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        border = BorderStroke(1.dp, TransGray)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = calenderUiState.date,
                fontSize = 20.sp,
            )
            Text(text = calenderUiState.day, color = Color.Gray)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PreviewCalenderItem() {
    CalenderItem(calenderUiState = CalenderUiState())
}