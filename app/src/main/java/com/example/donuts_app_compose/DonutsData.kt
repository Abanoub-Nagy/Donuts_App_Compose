package com.example.donuts_app_compose

import com.example.donut.R
import com.example.donuts_app_compose.ui.screens.home.DonutsUiState
import com.example.donuts_app_compose.ui.screens.home.TodayOfferUiState

object DonutsData {

    val todayOffers = listOf(
        TodayOfferUiState(
            image = R.drawable.doughnut_blueberry,
            title = "Blue Berry",
            description = "Delicious blueberry-filled doughnut topped with a sweet glaze.",
            originalPrice = 20,
            discountedPrice = 15,
        ),
        TodayOfferUiState(
            image = R.drawable.doughnut_chocolate_glaze_sprinkles,
            title = "Chocolate Glaze",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 30,
            discountedPrice = 25,
        ),
        TodayOfferUiState(
            image = R.drawable.doughnut_classic_plain,
            title = "Peanut Butter",
            description = "Irresistible doughnut filled with creamy peanut butter and topped with crushed peanuts.",
            originalPrice = 40,
            discountedPrice = 35,
        ),
        TodayOfferUiState(
            image = R.drawable.doughnut_peanut_butter,
            title = "Peanut Butter",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
            originalPrice = 41,
            discountedPrice = 12,
        )
    )
    val donuts = listOf(
        DonutsUiState(
            image = R.drawable.doughnut_chocolate_cherry_drizzle,
            title = "Chocolate Cherry",
            price = 25
        ),
        DonutsUiState(
            image = R.drawable.doughnut_strawberry_rain_sprinkles,
            title = "StrawBerry Rain",
            price = 21
        ),
        DonutsUiState(
            image = R.drawable.doughnut_strawberry_chocolate_drizzle,
            title = "StrawBerry Chocolate",
            price = 15
        ),
        DonutsUiState(
            image = R.drawable.doughnut_purple_sprinkles,
            title = "Purple Sprinkles",
            price = 42
        ),
    )

}
