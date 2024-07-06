package com.example.recipeapp.utils

fun handleLogin(email: String, password: String): Boolean {
    return email.isNotEmpty() && password.isNotEmpty()
}