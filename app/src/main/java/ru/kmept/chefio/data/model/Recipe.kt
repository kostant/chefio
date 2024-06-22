package ru.kmept.kormezhka.data.model

import java.util.Date

data class Recipe(
    val id: Int,
    val name: String,
    val author: User,
    val duration: Int,
    val pictureUrl: String,
    val createdAt: Date,
    val description: String,
    val likesCount: Int
)