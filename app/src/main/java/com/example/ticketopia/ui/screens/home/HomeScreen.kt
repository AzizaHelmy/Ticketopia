package com.example.ticketopia.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ticketopia.R
import com.example.ticketopia.ui.composable.BluredImage
import com.example.ticketopia.ui.composable.IconBottomNav
import com.example.ticketopia.ui.composable.IconWithCircularShape
import com.example.ticketopia.ui.composable.MovieGenres
import com.example.ticketopia.ui.composable.SpacerHorizontal8
import com.example.ticketopia.ui.composable.SpacerVertical16
import com.example.ticketopia.ui.composable.SpacerVertical32
import com.example.ticketopia.ui.composable.TextChip
import com.example.ticketopia.ui.composable.TextHeader
import com.example.ticketopia.ui.composable.ViewPager
import com.example.ticketopia.ui.navigation.navigateToMovieDetailsScreen
import com.example.ticketopia.ui.viewmodel.HomeViewModel
import com.example.ticketopia.ui.viewmodel.state.HomeUiState

/**
 * Created by Aziza Helmy on 7/4/2023.
 */

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    HomeContent(state, viewModel::updateBackgroundImage) {
        navController.navigateToMovieDetailsScreen()
    }
}

@Composable
private fun HomeContent(
    homeUiState: HomeUiState,
    onUpdateBackgroundImage: (String) -> Unit,
    // listener: HomeScreenInteractionsListener,
    onClickHomeIcon: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BluredImage(homeUiState)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextChip(
                    isSelected = homeUiState.nowShowingChip.isSelected,
                    text = homeUiState.nowShowingChip.title,
                    isEnabled = true,
                    //doWhenClick = listener::onClickNowShowing
                )
                TextChip(
                    isSelected = homeUiState.comingSoonChip.isSelected,
                    text = homeUiState.comingSoonChip.title,
                    isEnabled = true,
                    // doWhenClick = listener::onClickComingSoon
                )
            }
            SpacerVertical16()
            ViewPager(
                images = homeUiState.moviesUrl,
                onUpdateBackgroundImage = onUpdateBackgroundImage
            )
            SpacerVertical32()
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.icon_time),
                    contentDescription = "Time Icon "
                )
                SpacerHorizontal8()
                Text(text = homeUiState.duration)
            }
            SpacerVertical16()
            TextHeader(text = homeUiState.movieName)
            SpacerVertical16()
            MovieGenres()
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation {
                onClickHomeIcon
            }
        }
    }
}

@Composable
private fun BottomNavigation(onClickHomeIcon: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconWithCircularShape(
            painter = painterResource(id = R.drawable.icon_play),
            onClick = onClickHomeIcon
        )
        IconBottomNav(painter = painterResource(id = R.drawable.icon_play))
        IconBottomNav(painter = painterResource(id = R.drawable.icon_play))
        IconBottomNav(painter = painterResource(id = R.drawable.icon_play))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}