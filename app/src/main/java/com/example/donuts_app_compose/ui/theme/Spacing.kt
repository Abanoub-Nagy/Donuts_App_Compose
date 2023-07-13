package com.example.donuts_app_compose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val _0: Dp = 0.dp,
    val _2: Dp = 2.dp,
    val _4: Dp = 4.dp,
    val _8: Dp = 8.dp,
    val _16: Dp = 16.dp,
    val _24: Dp = 24.dp,
    val _32: Dp = 32.dp,
    val _64: Dp = 64.dp,
    val _128: Dp = 128.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
