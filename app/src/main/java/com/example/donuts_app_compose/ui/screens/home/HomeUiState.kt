package com.example.donuts_app_compose.ui.screens.home

data class HomeUiState(
    val todayOffer: List<TodayOfferUiState> = emptyList(),
    val donuts: List<DonutsUiState> = emptyList()
)

data class TodayOfferUiState(
    val favouriteIcon: Boolean = false,
    val image: Int = 0,
    val title: String = "",
    val description: String = "",
    val originalPrice: Int = 0,
    val discountedPrice: Int = 0
)

data class DonutsUiState(
    val image: Int = 0,
    val title: String = "",
    val price: Int = 0
)