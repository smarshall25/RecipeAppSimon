package com.example.recipeapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.navigation.AppNavigation
import com.example.recipeapp.navigation.Screen

@Composable
fun MainScreen(
    recipes: List<Recipe>,
    onRecipeAdded: (Recipe) -> Unit,
    onRecipeRemoved: (Recipe) -> Unit,
    email: String,
    onLogout: () -> Unit
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                Screen.values().forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.route) },
                        label = { Text(screen.route) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavigation(
            navController = navController,
            recipes = recipes,
            onRecipeAdded = onRecipeAdded,
            onRecipeRemoved = onRecipeRemoved,
            email = email,
            onLogout = onLogout,
            modifier = Modifier.padding(paddingValues)
        )
    }
}
