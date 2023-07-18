package com.example.donuts_app_compose.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.donuts_app_compose.AppDestination

fun NavGraphBuilder.homeRoute(navHostController: NavHostController) {
    composable(AppDestination.HomeScreen.route) { HomeScreen(navHostController) }
}

fun NavController.navigateToHomeScreen() {
    navigate(AppDestination.HomeScreen.route)
}