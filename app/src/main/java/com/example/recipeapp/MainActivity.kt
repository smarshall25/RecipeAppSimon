package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.recipeapp.models.Recipe
import com.example.recipeapp.ui.MainScreen
import com.example.recipeapp.ui.screens.screens.LoginScreen
import com.example.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var email by remember { mutableStateOf("") }
                val recipes = remember { mutableStateListOf<Recipe>() }

                // Wczytuje przepisy z Preferences
                recipes.addAll(loadRecipesFromPreferences(this))

                if (isLoggedIn) {
                    MainScreen(
                        recipes = recipes,
                        onRecipeAdded = { recipe ->
                            recipes.add(recipe)
                            saveRecipesToPreferences(this, recipes)
                        },
                        onRecipeRemoved = { recipe ->
                            recipes.remove(recipe)

                        },
                        email = email,
                        onLogout = {
                            isLoggedIn = false
                            email = ""
                            finish() // zamyka aplikację po naciśnieniu Log Out
                        }
                    )
                } else {
                    LoginScreen { inputEmail, password ->
                        if (handleLogin(inputEmail, password)) {
                            isLoggedIn = true
                            email = inputEmail
                        }else{
                            //KIEDYŚ TU DODAM WALIDACJE
                        }
                    }
                }
            }
        }
    }
}

fun handleLogin(email: String, password: String): Boolean {
    return email.isNotEmpty() && password.isNotEmpty()
}
