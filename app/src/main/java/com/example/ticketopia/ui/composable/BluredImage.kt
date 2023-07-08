package com.example.ticketopia.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.ticketopia.ui.screens.home.HomeUiState

/**
 * Created by Aziza Helmy on 7/7/2023.
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BluredImage(homeUiState: HomeUiState, pagerState: PagerState) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .blur(radius = 50.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded),
        painter = rememberAsyncImagePainter(model = homeUiState.moviesUrl[pagerState.currentPage]),
        contentScale = ContentScale.Crop,
        contentDescription = "Background ",
    )
}