package com.example.ticketopia.ui.viewmodel.state

/**
 * Created by Aziza Helmy on 7/5/2023.
 */
data class HomeUiState(val movies: List<MovieUiState> = emptyList())
data class MovieUiState(val imageUrl: String = "")