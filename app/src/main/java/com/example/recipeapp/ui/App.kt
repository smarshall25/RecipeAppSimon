package com.example.recipeapp.ui

import androidx.compose.runtime.Composable
import com.example.recipeapp.models.Recipe

@Composable
fun App(
    recipes: List<Recipe>,
    onRecipeAdded: (Recipe) -> Unit,
    onRecipeRemoved: (Recipe) -> Unit,
    email: String,
    onLogout: () -> Unit
) {
    MainScreen(
        recipes = recipes,
        onRecipeAdded = onRecipeAdded,
        onRecipeRemoved = onRecipeRemoved,
        email = email,
        onLogout = onLogout
    )
}
