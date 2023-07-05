package com.example.ticketopia.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ticketopia.ui.viewmodel.state.CharacterUiState
import com.example.ticketopia.ui.viewmodel.state.MovieDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@HiltViewModel
class MovieDetailsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(MovieDetailsUiState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        _state.update {
            it.copy(
                characters = listOf(
                    CharacterUiState("https://freerangestock.com/sample/125944/old-woman-in-white-hijab-.jpg"),
                    CharacterUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg"),
                    CharacterUiState("https://freerangestock.com/sample/125944/old-woman-in-white-hijab-.jpg"),
                    CharacterUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg"),
                    CharacterUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg")
                )
            )
        }

    }
}