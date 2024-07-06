package com.example.recipeapp.models

data class Recipe(
    val name: String,
    val description: String,
    val instructions: String,
    val ingredients: List<String>
)
