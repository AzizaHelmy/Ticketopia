package com.example.ticketopia.ui.viewmodel.state

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
data class BookingUiState(
    val calender: List<CalenderUiState> = emptyList(),
    val times: List<String> = emptyList()
)

data class CalenderUiState(
    val date: String = "",
    val day: String = ""
)