package com.example.ticketopia.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.ticketopia.R
import com.example.ticketopia.ui.composable.CircularImage
import com.example.ticketopia.ui.composable.DefaultButton
import com.example.ticketopia.ui.composable.ExitIcon
import com.example.ticketopia.ui.composable.IconWithCircularShape
import com.example.ticketopia.ui.composable.MovieGenres
import com.example.ticketopia.ui.composable.SpacerVertical16
import com.example.ticketopia.ui.composable.TextChip
import com.example.ticketopia.ui.composable.TextHeader
import com.example.ticketopia.ui.navigation.navigateToBookingScreen
import com.example.ticketopia.ui.navigation.navigateToHomeScreen
import com.example.ticketopia.ui.theme.TransGray
import com.example.ticketopia.ui.theme.White

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(
        state,
        onClickBookingIcon = { navController.navigateToBookingScreen() },
        onClickExitIcon = { navController.navigateToHomeScreen() })
}

@Composable
private fun MovieDetailsContent(
    state: MovieDetailsUiState,
    onClickBookingIcon: () -> Unit,
    onClickExitIcon: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxHeight(0.4f)) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.movie_1),
                    contentDescription = "Movie Image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.Center
                )
                IconWithCircularShape(painter = painterResource(id = R.drawable.icon_play))
            }
            ToolBar(onClickExitIcon = onClickExitIcon)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(3 / 4f)
                .clip(
                    shape = AbsoluteRoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp),
                )
                .background(
                    color = Color.White
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 26.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = stringResource(R.string._6_8_10))
                            Text(text = stringResource(R.string.imdb), color = Color.Gray)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = stringResource(R.string._63))
                            Text(
                                text = stringResource(R.string.rotten_tomatoes),
                                color = Color.Gray
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = stringResource(R.string._4_10))
                            Text(text = stringResource(R.string.ign), color = Color.Gray)
                        }
                    }
            TextHeader(text = state.movieName)
            MovieGenres()
            SpacerVertical16()
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.characters) {
                    CharacterItem(character = it)
                }
            }
            Text(
                text = state.movieDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 20.dp, end = 10.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            DefaultButton(
                text = stringResource(R.string.booking),
                icon = painterResource(id = R.drawable.icon_booking),
                modifier = Modifier.padding(bottom = 40.dp),
                onClick = onClickBookingIcon
            )
                }
    }
}


@Composable
private fun ToolBar(onClickExitIcon: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ExitIcon(onClick = onClickExitIcon)
        TextChip(
            isSelected = false,
            isEnabled = false,
            text = "2h 23m",
            unSelectedBorderColor = Color.Transparent,
            unSelectedTextColor = White,
            iconId = R.drawable.icon_time,
            rowModifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(TransGray)
                .border(0.dp, Color.Transparent)
        )
    }
}


@Composable
fun CharacterItem(character: CharacterUiState) {
    CircularImage(painter = rememberAsyncImagePainter(character.imageUrl))
}


@Preview(showSystemUi = true)
@Composable
fun PreviewMovieContent() {
    MovieDetailsScreen(NavHostController(LocalContext.current))
}