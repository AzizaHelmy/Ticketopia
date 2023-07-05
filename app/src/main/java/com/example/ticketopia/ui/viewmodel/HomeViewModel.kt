package com.example.ticketopia.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ticketopia.ui.viewmodel.state.HomeUiState
import com.example.ticketopia.ui.viewmodel.state.MovieUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        _state.update {
            it.copy(
                movies = listOf(
                    MovieUiState("https://freerangestock.com/sample/125944/old-woman-in-white-hijab-.jpg"),
                    MovieUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg"),
                    MovieUiState("https://freerangestock.com/sample/125944/old-woman-in-white-hijab-.jpg"),
                    MovieUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg"),
                    MovieUiState("https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg")
                )
            )
        }
    }
}