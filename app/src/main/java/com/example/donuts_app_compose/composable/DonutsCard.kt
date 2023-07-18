package com.example.donuts_app_compose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donuts_app_compose.ui.screens.home.DonutsUiState
import com.example.donuts_app_compose.ui.theme.Black80
import com.example.donuts_app_compose.ui.theme.Donuts_App_ComposeTheme
import com.example.donuts_app_compose.ui.theme.Pink90
import com.example.donuts_app_compose.ui.theme.SecondaryColor
import com.example.donuts_app_compose.ui.theme.Typography

@Composable
fun DonutsCard(
    modifier: Modifier = Modifier,
    Click: () -> Unit,
    state: DonutsUiState = DonutsUiState(),
    backgroundTint: Color = SecondaryColor,
) {
    Box(modifier = modifier.size(180.dp)) {
        Surface(
            Modifier
                .padding(top = 60.dp)
                .fillMaxHeight()
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .background(backgroundTint)
                .shadow(
                    elevation = 16.dp,
                    spotColor = SecondaryColor,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .clickable(onClick = Click)
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = state.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, bottom = 10.dp),
                    style = Typography.titleSmall.copy(Black80),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "€${state.price}",
                    style = Typography.labelSmall.copy(color = Pink90),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                )
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .matchParentSize()
                .graphicsLayer {
                    translationY = -120f
                }
                .scale(.9f),
            painter = painterResource(id = state.image),
            contentDescription = "donut"
        )
    }
}

@Preview
@Composable
fun DoughnutMiniCardPreview() {
    Donuts_App_ComposeTheme() {
        DonutsCard(Click = {})
    }
}