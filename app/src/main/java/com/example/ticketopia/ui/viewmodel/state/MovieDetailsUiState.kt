package com.example.ticketopia.ui.viewmodel.state

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
data class MovieDetailsUiState(val characters: List<CharacterUiState> = emptyList())

data class CharacterUiState(val imageUrl: String = "")
