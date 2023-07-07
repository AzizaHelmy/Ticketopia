package com.example.ticketopia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

/**
 * Created by Aziza Helmy on 7/7/2023.
 */
@Composable
fun TiketopiaNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "homeScreen") {
        homeRoute(navController)
        bookingRoute(navController)
        movieDetailsRoute(navController)
    }
}
