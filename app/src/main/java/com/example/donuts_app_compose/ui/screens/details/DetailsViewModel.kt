package com.example.donuts_app_compose.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.donuts_app_compose.DonutsData
import com.example.donuts_app_compose.ui.theme.BlueCard
import com.example.donuts_app_compose.ui.theme.PinkCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), DetailsInteractionListener {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    private val args = DetailsArgs(savedStateHandle)

    init {
        getData()
    }

    private fun getData() {
        val id = args.id.toString().toInt()
        DonutsData.todayOffers.mapIndexed { index, todayOfferUiState ->
            if (id == index) {
                _state.update {
                    it.copy(
                        image = todayOfferUiState.image,
                        title = todayOfferUiState.title,
                        description = todayOfferUiState.description,
                        price = todayOfferUiState.discountedPrice,
                        backgroundColor = if (index % 2 != 0) BlueCard else PinkCard,
                        favorite = todayOfferUiState.favouriteIcon
                    )
                }
            }
        }
    }

    override fun onClickCardFavoriteIcon() {
        _state.update { it.copy(favorite = !_state.value.favorite) }
    }

    override fun onClickPlusIcon() {
        val disc = DonutsData.todayOffers[args.id.toString().toInt()].discountedPrice
        _state.update {
            it.copy(
                quantity = _state.value.quantity + 1,
                price = _state.value.price + disc
            )
        }
    }

    override fun onClickMinusIcon() {
        val disc = DonutsData.todayOffers[args.id.toString().toInt()].discountedPrice
        _state.update {
            it.copy(
                quantity = if (_state.value.quantity > 0) _state.value.quantity - 1 else return,
                price = _state.value.price - disc
            )
        }
    }


}