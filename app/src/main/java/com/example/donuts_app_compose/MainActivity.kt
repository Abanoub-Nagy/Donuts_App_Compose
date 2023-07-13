package com.example.donuts_app_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.donuts_app_compose.ui.theme.Donuts_App_ComposeTheme
import com.example.donuts_app_compose.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Donuts_App_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.padding(
                        MaterialTheme.spacing._8
                    ),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DonutApp()
                }
            }
        }
    }
}