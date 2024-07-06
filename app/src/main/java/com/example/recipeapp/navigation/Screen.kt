package com.example.recipeapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(val route: String, val icon: ImageVector) {
    Home("Przepisy", Icons.Default.Home),
    Profile("Moje przepisy", Icons.Default.Person),
    Settings("Ustawienia", Icons.Default.Settings)
}
