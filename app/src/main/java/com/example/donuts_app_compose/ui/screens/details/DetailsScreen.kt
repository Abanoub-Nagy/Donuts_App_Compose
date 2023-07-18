package com.example.donuts_app_compose.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donut.R
import com.example.donuts_app_compose.composable.BottomSheet
import com.example.donuts_app_compose.composable.BottomSheetDetails
import com.example.donuts_app_compose.composable.FavoriteAnimation
import com.example.donuts_app_compose.ui.theme.Pink30
import com.example.donuts_app_compose.ui.theme.Pink90
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    DetailsContent(state, { navHostController.popBackStack() }, viewModel)
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    onBackClick: () -> Unit,
    detailsInteractionListener: DetailsInteractionListener
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Pink30)

    Box(
        modifier = Modifier
            .background(state.backgroundColor)
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onBackClick()
                    }
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back to home screen",
                tint = Pink90
            )
        }
        Image(
            modifier = Modifier
                .scale(4.0f)
                .padding(top = 80.dp, bottom = 16.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(state.image),
            contentDescription = null
        )
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSheet(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            ) {
                BottomSheetDetails(state, detailsInteractionListener)
            }
            FavoriteAnimation(
                iconState = state.favorite,
                roundedSize = 12,
                onClickIconFavorite = detailsInteractionListener::onClickCardFavoriteIcon,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 8.dp)
                    .offset(y = (-30).dp),
            )
        }
    }
}
