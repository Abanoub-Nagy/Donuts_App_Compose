package com.example.donuts_app_compose.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.donuts_app_compose.DonutsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), HomeInteractionListener {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        _state.update { it.copy(todayOffer = DonutsData.todayOffers, donuts = DonutsData.donuts) }
    }


    override fun onClickFavoriteIcon(pos: Int) {
        val currentState = _state.value
        val updatedTodayDonuts = currentState.todayOffer.mapIndexed { index, todayOfferUiState ->
            if (index == pos) {
                todayOfferUiState.copy(favouriteIcon = !todayOfferUiState.favouriteIcon)
            } else {
                todayOfferUiState
            }
        }
        val updatedState = currentState.copy(todayOffer = updatedTodayDonuts)
        _state.value = updatedState
    }
}