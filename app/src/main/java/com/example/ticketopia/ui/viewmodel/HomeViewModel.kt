package com.example.ticketopia.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ticketopia.ui.interactions.HomeScreenInteractionsListener
import com.example.ticketopia.ui.viewmodel.state.ChipUiState
import com.example.ticketopia.ui.viewmodel.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), HomeScreenInteractionsListener {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMoviesList()
        getMovieDetails()
    }

    private fun getMovieDetails() {
        _state.update {
            it.copy(
                nowShowingChip = ChipUiState(title = "Now Showing", isSelected = true),
                comingSoonChip = ChipUiState(title = "Coming Soon", isSelected = false)
            )
        }
    }

    private fun getMoviesList() {
        _state.update {
            it.copy(
                moviesUrl = listOf(
                    "https://www.fantasticbeasts.com/images/share.jpg",
                    "https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg",
                    "https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg",
                    "https://cdn.europosters.eu/image/1300/art-photo/fantastic-beasts-the-secrets-of-dumbledore-i123036.jpg",
                    "https://i.ytimg.com/vi/1o_MjaF_E2o/maxresdefault.jpg",
                    "https://wallpapers.com/images/hd/cool-profile-picture-87h46gcobjl5e4xu.jpg"
                )
            )
        }
    }

    override fun onClickNowShowing() {
        _state.update {
            it.copy(
                nowShowingChip = ChipUiState(isSelected = true),
                comingSoonChip = ChipUiState(isSelected = false)
            )
        }
    }

    override fun onClickComingSoon() {
        _state.update {
            it.copy(
                nowShowingChip = ChipUiState(isSelected = false),
                comingSoonChip = ChipUiState(isSelected = true)
            )
        }

    }
}