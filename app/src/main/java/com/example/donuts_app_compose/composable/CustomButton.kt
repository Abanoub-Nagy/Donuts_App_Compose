package com.example.donuts_app_compose.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.donuts_app_compose.ui.theme.Typography

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = Color.White,
    textColor: Color = Color.Black
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(4.dp),
            style = Typography.labelLarge.copy(color = textColor)
        )

    }
}