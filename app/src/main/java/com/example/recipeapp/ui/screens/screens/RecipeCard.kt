package com.example.recipeapp.ui.screens.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.models.Recipe

@Composable
fun RecipeCard(recipe: Recipe, onDelete: (Recipe) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = recipe.name ?: "Bez nazwy", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recipe.description ?: "Bez opisu", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recipe.instructions ?: "Bez Instrukcji", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = recipe.ingredients.joinToString(", ") { it ?: "Bez skladników" }, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onDelete(recipe) }) {
                Text("Usuń przepis")
            }
        }
    }
}
