package com.example.donuts_app_compose.ui.screens.details

import androidx.compose.ui.graphics.Color
import com.example.donuts_app_compose.ui.theme.Pink30

data class DetailsUiState(
    val image: Int = 0,
    val backgroundColor: Color = Pink30,
    val favorite: Boolean = false,
    val title: String = "",
    val description: String = "",
    val price: Int = 0,
    val quantity: Int = 1
)