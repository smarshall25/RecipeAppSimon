package com.example.recipeapp.ui.screens.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipeapp.models.Recipe

@Composable
fun ProfileScreen(navController: NavController, onRecipeAdded: (Recipe) -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var instructions by remember { mutableStateOf(TextFieldValue("")) }
    var ingredients by remember { mutableStateOf(TextFieldValue("")) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nazwa potrawy") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Opis dania") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = instructions,
            onValueChange = { instructions = it },
            label = { Text("Instrukcja przygotowania") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = ingredients,
            onValueChange = { ingredients = it },
            label = { Text("Składniki") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val recipe = Recipe(
                name = name.text,
                description = description.text,
                instructions = instructions.text,
                ingredients = ingredients.text.split(",").map { it.trim() }
            )
            onRecipeAdded(recipe)
            name = TextFieldValue("")
            description = TextFieldValue("")
            instructions = TextFieldValue("")
            ingredients = TextFieldValue("")

        }) {
            Text("Dodaj przepis")
        }
    }
}
