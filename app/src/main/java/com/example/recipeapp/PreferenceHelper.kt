package com.example.recipeapp

import android.content.Context
import android.content.SharedPreferences
import com.example.recipeapp.models.Recipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private const val PREFS_NAME = "recipe_prefs"
private const val RECIPES_KEY = "recipes_key"

fun saveRecipesToPreferences(context: Context, recipes: List<Recipe>) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val gson = Gson()
    val json = gson.toJson(recipes)
    editor.putString(RECIPES_KEY, json)
    editor.apply()
}

fun loadRecipesFromPreferences(context: Context): List<Recipe> {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val gson = Gson()
    val json = sharedPreferences.getString(RECIPES_KEY, null)
    val type = object : TypeToken<List<Recipe>>() {}.type
    return if (json != null) {
        gson.fromJson(json, type)
    } else {
        emptyList()
    }
}
