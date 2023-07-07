package com.example.ticketopia.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ticketopia.ui.screens.HomeScreen

/**
 * Created by Aziza Helmy on 7/7/2023.
 */

private const val ROUTE = "homeScreen"

fun NavController.navigateToMovieDetailsScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navHostController: NavHostController) {
    composable(ROUTE) { HomeScreen(navHostController) }
}