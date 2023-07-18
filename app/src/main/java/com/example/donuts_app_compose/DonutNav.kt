package com.example.donuts_app_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.donuts_app_compose.ui.screens.boarding.boardingRoute
import com.example.donuts_app_compose.ui.screens.details.detailsRoute
import com.example.donuts_app_compose.ui.screens.home.homeRoute

@Composable
fun DonutNav(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = AppDestination.BoardingScreen.route,
    ) {
        homeRoute(navHostController)

        boardingRoute(navHostController)

        detailsRoute(navHostController)
    }

}