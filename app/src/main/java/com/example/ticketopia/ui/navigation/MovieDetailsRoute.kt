package com.example.ticketopia.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ticketopia.ui.screens.MovieDetailsScreen

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
private const val ROUTE = "movieDetailsRoute"


fun NavController.navigateToMovieDetailsScreen() {
    Log.e("TAG", "navigateToMovieDetailsScreen: ", )
    navigate(ROUTE)
}
fun NavGraphBuilder.movieDetailsRoute(navHostController: NavHostController) {
    composable(ROUTE) { MovieDetailsScreen(navHostController) }
}