package com.example.ticketopia.ui

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.ticketopia.ui.navigation.TiketopiaNavGraph

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketopiaApp() {
    Scaffold {
        val navController = rememberNavController()
        TiketopiaNavGraph(navController = navController)
    }

}
