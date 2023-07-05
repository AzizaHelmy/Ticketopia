package com.example.ticketopia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ticketopia.ui.composable.TextChip
import com.example.ticketopia.ui.theme.Orange
import com.example.ticketopia.ui.viewmodel.HomeViewModel
import com.example.ticketopia.ui.viewmodel.state.HomeUiState

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    HomeContent(state)
}

@Composable
private fun HomeContent(state: HomeUiState) {
    Row (verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceEvenly){
    TextChip(iconId =null , tintColor = Orange , isSelected =false , text ="Now Showing" , onChecked ={} )
    TextChip(iconId =null , tintColor = Orange , isSelected =false , text ="Now Showing" , onChecked ={} )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeContent(HomeUiState())
}