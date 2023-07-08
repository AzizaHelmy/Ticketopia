package com.example.ticketopia.ui.screens.details

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
data class MovieDetailsUiState(
    val characters: List<CharacterUiState> = emptyList(),
    val movieName: String = "Fantastic Beasts: The \nSecrets of Dumbledore",
    val movieDescription: String = "Professor Albus Dumbledore must assist Newt \nScamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
)

data class CharacterUiState(val imageUrl: String = "")
