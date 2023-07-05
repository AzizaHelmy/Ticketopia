package com.example.ticketopia.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.ticketopia.R
import com.example.ticketopia.ui.composable.DefaultButton
import com.example.ticketopia.ui.composable.SpacerVertical16
import com.example.ticketopia.ui.composable.TextChip
import com.example.ticketopia.ui.composable.TextHeader
import com.example.ticketopia.ui.viewmodel.MovieDetailsViewModel
import com.example.ticketopia.ui.viewmodel.state.CharacterUiState
import com.example.ticketopia.ui.viewmodel.state.MovieDetailsUiState

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(state)
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun MovieDetailsContent(state: MovieDetailsUiState) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            ToolBar()
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(370.dp)
        ) {

            Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.Center)) {
                Image(
                    painter = painterResource(id = R.drawable.icon_video_play),
                    contentDescription = ""
                )
            }
            Image(
                painter = painterResource(id = R.drawable.movie_1),
                contentDescription = "Movie Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(370.dp),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.Center
            )
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp)
                    .background(
                        shape = AbsoluteRoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp),
                        color = Color.White
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    SpacerVertical16()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column() {
                            Text(text = "6.8/10")
                            Text(text = "IMDb")
                        }
                        Column() {
                            Text(text = "6.8/10")
                            Text(text = "IMDb")
                        }
                        Column() {
                            Text(text = "6.8/10")
                            Text(text = "IMDb")
                        }
                    }
                    // SpacerVertical16()
                    TextHeader(text = "Fantastic Beasts: The Secrets Of Dumbledore")
                    SpacerVertical16()
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
                    SpacerVertical16()
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        items(state.characters) {
                            CharacterItem(character = it)
                        }
                    }
                    SpacerVertical16()
                    Text(
                        text = "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 20.dp, end = 10.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    DefaultButton(
                        text = stringResource(R.string.booking),
                        icon = painterResource(id = R.drawable.icon_booking)
                    )
                    SpacerVertical16()
                }
            }
        }

    }
}

@Composable
fun ToolBar() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id = R.drawable.icon_exit), contentDescription = "")
        TextChip(iconId = R.drawable.icon_time,
            tintColor = Color.DarkGray,
            isSelected = false,
            text = "2h 23m",
            onChecked = {})
    }
}

@Composable
fun CharacterItem(character: CharacterUiState) {
    Image(
        painter = rememberAsyncImagePainter(character.imageUrl),
        contentDescription = "Character Image",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(76.dp)
            .clip(CircleShape)
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showSystemUi = true)
@Composable
fun PreviewMovieContent() {
    MovieDetailsContent(MovieDetailsUiState())
}