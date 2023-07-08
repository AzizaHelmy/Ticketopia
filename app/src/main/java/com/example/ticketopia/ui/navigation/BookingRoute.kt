package com.example.ticketopia.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ticketopia.ui.screens.booking.BookingScreen

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
private const val ROUTE = "bookingRoute"

fun NavController.navigateToBookingScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.bookingRoute(navHostController: NavHostController) {
    composable(ROUTE) { BookingScreen(navHostController) }
}