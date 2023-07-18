package com.example.donuts_app_compose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.donut.R
import com.example.donuts_app_compose.composable.DonutsCard
import com.example.donuts_app_compose.composable.RoundedButton
import com.example.donuts_app_compose.composable.TodayDonutCard
import com.example.donuts_app_compose.ui.screens.details.navigateToDetailsScreen
import com.example.donuts_app_compose.ui.theme.Background
import com.example.donuts_app_compose.ui.theme.Black
import com.example.donuts_app_compose.ui.theme.Black80
import com.example.donuts_app_compose.ui.theme.BlueCard
import com.example.donuts_app_compose.ui.theme.Pink30
import com.example.donuts_app_compose.ui.theme.Pink90
import com.example.donuts_app_compose.ui.theme.PinkCard
import com.example.donuts_app_compose.ui.theme.Typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(state, viewModel, navHostController)
}

@Composable
fun HomeContent(
    state: HomeUiState,
    homeInteractionListener: HomeInteractionListener,
    navHostController: NavHostController,
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Pink30)
    systemUiController.setNavigationBarColor(Background)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentPadding = PaddingValues(top = 32.dp, bottom = 16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Let’s Gonuts!",
                        style = Typography.headlineMedium.copy(color = Pink90)
                    )
                    Text(
                        text = "Order your favourite donuts from here",
                        style = Typography.titleSmall.copy(color = Black80)
                    )
                }
                RoundedButton(onClick = {}) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Icon",
                        tint = Pink90
                    )
                }
            }
        }
        item {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 54.dp),
                text = "Today Offers",
                style = Typography.labelLarge.copy(Black)
            )
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, end = 60.dp),
                horizontalArrangement = Arrangement.spacedBy(70.dp),
                modifier = Modifier.padding(top = 25.dp)
            ) {
                itemsIndexed(state.todayOffer) { index, item ->
                    val color = if (index % 2 != 0) BlueCard else PinkCard
                    TodayDonutCard(
                        backgroundTint = color, state = state.todayOffer[index],
                        onClickCard = { navHostController.navigateToDetailsScreen(index) },
                        onClickIconFavorite = {
                            homeInteractionListener.onClickFavoriteIcon(index)
                        }
                    )
                }
            }
        }
        item {
            Text(
                modifier = Modifier.padding(start = 16.dp, bottom = 17.dp, top = 46.dp),
                text = "Donuts",
                style = Typography.labelLarge.copy(color = Black)
            )
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(23.dp),
                modifier = Modifier.padding(top = 25.dp)
            ) {
                itemsIndexed(state.donuts) { index, item ->
                    DonutsCard(
                        state = state.donuts[index],
                        Click = { navHostController.navigateToDetailsScreen(index) },
                    )
                }
            }
        }
    }
}