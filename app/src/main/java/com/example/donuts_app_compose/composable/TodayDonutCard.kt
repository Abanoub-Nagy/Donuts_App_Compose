package com.example.donuts_app_compose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.donut.R
import com.example.donuts_app_compose.ui.screens.home.TodayOfferUiState
import com.example.donuts_app_compose.ui.theme.Background
import com.example.donuts_app_compose.ui.theme.Black
import com.example.donuts_app_compose.ui.theme.Black80
import com.example.donuts_app_compose.ui.theme.Pink30
import com.example.donuts_app_compose.ui.theme.SecondaryColor
import com.example.donuts_app_compose.ui.theme.Typography

@Composable
fun TodayDonutCard(
    backgroundTint: Color = Pink30,
    state: TodayOfferUiState = TodayOfferUiState(),
    onClickCard: () -> Unit,
    onClickIconFavorite: () -> Unit
) {
    Box(
        contentAlignment = Alignment.CenterEnd, modifier = Modifier
            .height(325.dp)
            .width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(20.dp))
                .background(backgroundTint)
                .shadow(elevation = 1.dp, spotColor = SecondaryColor)
                .clickable { onClickCard() },
        ) {
            Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp)) {
                val isActive = remember { mutableStateOf(false) }
                Image(
                    painter = painterResource(id = if (isActive.value) R.drawable.ic_heart_filled else R.drawable.heart_add_to_favourite),
                    contentDescription = "add to favourite icon",
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { isActive.value = !isActive.value }
                        .background(Background)
                        .padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(vertical = 4.dp),
                        text = state.title,
                        style = Typography.titleMedium.copy(color = Black)
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp),
                        text = state.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.bodySmall.copy(color = Black80)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 4.dp),
                            text = "$${state.originalPrice}",
                            style = Typography.labelSmall.copy(
                                color = Black80,
                                textDecoration = TextDecoration.LineThrough
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$${state.discountedPrice}",
                            style = Typography.displayMedium.copy(color = Black)
                        )
                    }
                }
            }
        }
        Image(
            painter = painterResource(id = state.image),
            contentDescription = "Doughnut",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth(.8f)
                .fillMaxHeight(.45f)
                .graphicsLayer {
                    translationX = (this.size.width - 130) / 2
                    translationY = -120f
                }
                .scale(1.1f)
        )
    }
}
