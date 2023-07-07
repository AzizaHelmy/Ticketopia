package com.example.ticketopia.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ticketopia.ui.screens.MovieDetailsScreen

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
private const val ROUTE = "movieDetailsRoute"

fun NavController.navigateToHomeScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.movieDetailsRoute(navHostController: NavHostController) {
    composable(ROUTE) { MovieDetailsScreen(navHostController) }
}