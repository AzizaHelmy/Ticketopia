package com.example.ticketopia.ui.screens.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ticketopia.R
import com.example.ticketopia.ui.composable.CalenderItem
import com.example.ticketopia.ui.composable.DefaultButton
import com.example.ticketopia.ui.composable.ExitIcon
import com.example.ticketopia.ui.composable.SeatItem
import com.example.ticketopia.ui.composable.TimeItem
import com.example.ticketopia.ui.navigation.navigateToHomeScreen
import com.example.ticketopia.ui.theme.Adamina
import com.example.ticketopia.ui.theme.Orange
import com.example.ticketopia.ui.theme.White
import com.example.ticketopia.ui.viewmodel.BookingViewModel
import com.example.ticketopia.ui.viewmodel.state.BookingUiState

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@Composable
fun BookingScreen(navController: NavController, viewModel: BookingViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    BookingContent(
        bookingUiState = state,
        onClickBuyTicket = { navController.navigateToHomeScreen() })
}

@Composable
private fun BookingContent(bookingUiState: BookingUiState, onClickBuyTicket: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Column(
            Modifier
                .aspectRatio(3 / 4f)
                .fillMaxWidth()
        ) {
            ExitIcon(modifier = Modifier.padding(16.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .drawWithContent {
                        val gradient = Brush.linearGradient(
                            colors = listOf(Color.Transparent, Black),
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height)
                        )
                        drawContent()
                        drawRect(brush = gradient)
                    },
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.cinema_screen),
                contentDescription = "Cinema Screen"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (column in 0..2) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        for (seat in 0..4) {
                            when (column) {
                                0 -> {
                                    SeatItem(
                                        startIconColor = Orange,
                                        endIconColor = White,
                                        rotateDegree = 10f
                                    )
                                }

                                2 -> {
                                    SeatItem(
                                        startIconColor = White,
                                        endIconColor = Orange,
                                        rotateDegree = -10f
                                    )
                                }

                                else -> {
                                    SeatItem(
                                        startIconColor = Color.Gray,
                                        endIconColor = White,
                                    )
                                }
                            }

                        }
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SeatStates(text = stringResource(R.string.available), color = Orange)
                SeatStates(text = stringResource(R.string.taken), color = White)
                SeatStates(text = stringResource(R.string.selected), color = Color.Gray)
            }

        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .clip(
                    shape = AbsoluteRoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp),
                )
                .background(
                    color = Color.White
                )
                .padding(16.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(bookingUiState.calender) {
                    CalenderItem(calenderUiState = it)
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(bookingUiState.times) {
                    TimeItem(time = it)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string._100), fontFamily = Adamina,
                        fontSize = 24.sp,
                    )
                    Text(text = stringResource(R.string._4_tickets), color = Color.Gray)
                }
                DefaultButton(
                    text = stringResource(R.string.buy_ticket),
                    icon = painterResource(id = R.drawable.icon_booking),
                    onClick = onClickBuyTicket
                )
            }
        }
    }


}

@Composable
private fun SeatStates(text: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(shape = CircleShape)
                .background(color)
        )
        Text(text = text, color = White)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewBookingScreen() {
    BookingScreen(NavHostController(LocalContext.current))
}