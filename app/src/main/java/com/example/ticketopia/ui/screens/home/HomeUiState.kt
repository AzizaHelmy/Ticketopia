package com.example.ticketopia.ui.screens.home

/**
 * Created by Aziza Helmy on 7/5/2023.
 */
data class HomeUiState(
    val nowShowingChip: ChipUiState = ChipUiState("", true),
    val comingSoonChip: ChipUiState = ChipUiState("", false),
    val moviesUrl: List<String> = emptyList(),
    val duration: String = "2h 23m",
    val movieName: String = "Fantastic Beasts: The \nSecrets of Dumbledore",
    val currentImage: String = ""
)

data class ChipUiState(
    val title: String="",
    val isSelected: Boolean = false
)