package com.example.ticketopia.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ticketopia.ui.viewmodel.state.BookingUiState
import com.example.ticketopia.ui.viewmodel.state.CalenderUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@HiltViewModel
class BookingViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    init {
        getCalender()
        getTimes()
    }

    private fun getCalender() {
        _state.update {
            it.copy(
                calender = listOf(
                    CalenderUiState(date = "15", day = "Fri"),
                    CalenderUiState(date = "16", day = "Sat"),
                    CalenderUiState(date = "17", day = "Sun"),
                    CalenderUiState(date = "18", day = "Mon"),
                    CalenderUiState(date = "19", day = "Tue"),
                    CalenderUiState(date = "120", day = "Wen"),
                    CalenderUiState(date = "120", day = "Wen"),
                    CalenderUiState(date = "120", day = "Wen"),
                    CalenderUiState(date = "120", day = "Wen"),
                    CalenderUiState(date = "120", day = "Wen"),
                )
            )
        }
    }

    private fun getTimes() {
        _state.update {
            it.copy(
                times = listOf(
                    "10:00",
                    "12:30",
                    "15:00",
                    "18:45",
                    "20:00",
                    "22:00",
                    "22:00",
                    "22:00",
                    "22:00",
                    "22:00",
                    "22:00",
                    "22:00",
                )
            )
        }
    }


}