package com.uoa.sensordatacollection.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SensorTrackingTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) {
        // Define your dark mode color scheme here
        DarkColorScheme
    } else {
        // Define your light mode color scheme here
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors
    ) {
        content()
    }
}

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
    error = Color(0xFFB00020),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,

)

private val DarkColorScheme = darkColorScheme(
    // Define your dark mode color scheme here
    // You can adjust the colors as needed
    // Example:
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color.Black,
    surface = Color.Black,
    error = Color(0xFFCF6679),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black,
)
