package com.example.donuts_app_compose.ui.screens.boarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.donuts_app_compose.AppDestination

fun NavGraphBuilder.boardingRoute(navHostController: NavHostController) {
    composable(AppDestination.BoardingScreen.route) { BoardingScreen(navHostController) }
}