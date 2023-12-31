package com.example.ticketopia.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * Created by Aziza Helmy on 7/6/2023.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPager(
    images: List<String>,
    modifier: Modifier = Modifier,
    onClickImage: () -> Unit = {},
    pagerState: PagerState
) {

    HorizontalPager(
        modifier = modifier,
        pageCount = images.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
    ) { currentPage ->


        val animatedScale by animateFloatAsState(
            targetValue = if (currentPage == pagerState.currentPage) 1f else 0.9f,
            animationSpec = tween(durationMillis = 200)
        )
        Image(
            painter = rememberAsyncImagePainter(model = images[currentPage]),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(3 / 4f)
                .scale(animatedScale)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(color = Color.DarkGray)
                .clickable { onClickImage() }
        )
    }
}