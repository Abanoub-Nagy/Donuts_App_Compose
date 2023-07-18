package com.example.donuts_app_compose

sealed class AppDestination(val route: String) {

    object BoardingScreen : AppDestination("boardingScreen")

    object HomeScreen : AppDestination("homeScreen")

    object DetailsScreen : AppDestination("detailsScreen")

}

