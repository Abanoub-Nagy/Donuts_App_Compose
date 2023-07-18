package com.example.donuts_app_compose.ui.screens.boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.donut.R
import com.example.donuts_app_compose.composable.CustomButton
import com.example.donuts_app_compose.ui.screens.home.navigateToHomeScreen
import com.example.donuts_app_compose.ui.theme.Pink30
import com.example.donuts_app_compose.ui.theme.Pink60
import com.example.donuts_app_compose.ui.theme.Pink90
import com.example.donuts_app_compose.ui.theme.Typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BoardingScreen(navHostController: NavHostController) {
    BoardingContent {
        navHostController.navigateToHomeScreen()
    }
}

@Composable
fun BoardingContent(
    navToHomeScreen: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Pink30)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink30)
    ) {
        Image(
            modifier = Modifier
                .size(400.dp)
                .padding(top = 64.dp)
                .align(Alignment.TopCenter)
                .scale(1.8f),
            painter = painterResource(id = R.drawable.image),
            contentDescription = "donuts"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.gonuts_with_dounts),
                style = Typography.headlineLarge.copy(color = Pink90)
            )
            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 60.dp),
                text = stringResource(R.string.boarding_descreption),
                style = Typography.bodyMedium.copy(color = Pink60)
            )
            CustomButton(text = "Get Started", onClick = { navToHomeScreen() })
        }
    }
}