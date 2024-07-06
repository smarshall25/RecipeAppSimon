package com.example.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.ui.screens.screens.*

@Composable
fun AppNavigation(
    navController: NavHostController,
    recipes: List<Recipe>,
    onRecipeAdded: (Recipe) -> Unit,
    onRecipeRemoved: (Recipe) -> Unit,
    email: String,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(recipes = recipes, onRecipeRemoved = onRecipeRemoved)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController, onRecipeAdded = onRecipeAdded)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(email = email, onLogout = onLogout)
        }
    }
}
