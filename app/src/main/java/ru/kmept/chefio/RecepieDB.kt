package ru.kmept.chefio

data class RecipeDB(
    val id: String,
    val name: String,
    val picture: String,
    val description: String,
    val ingredients: String,
    val stepJson: String,
    val duration: Int
)