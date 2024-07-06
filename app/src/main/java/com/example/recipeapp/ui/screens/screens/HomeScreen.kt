package com.example.recipeapp.ui.screens.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.models.Recipe

@Composable
fun HomeScreen(recipes: List<Recipe>, onRecipeRemoved: (Recipe) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Moje przepisy: ",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),


    ){
        items(recipes) { recipe ->
            RecipeCard(recipe, onDelete = { onRecipeRemoved(it) })
        }
    }
}
}

