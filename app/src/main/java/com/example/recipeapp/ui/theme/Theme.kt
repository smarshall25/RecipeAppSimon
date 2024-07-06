package com.example.recipeapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBB86FC),
    onPrimaryContainer = Color.Black,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
    error = Color(0xFFB00020),
    errorContainer = Color(0xFFFFDAD4),
    onError = Color.White,
    onErrorContainer = Color.Black,
    background = Color(0xFFFFFBFE),
    onBackground = Color.Black,
    surface = Color(0xFFFFFBFE),
    onSurface = Color.Black,
)

@Composable
fun RecipeAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
