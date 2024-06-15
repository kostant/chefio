package ru.kmept.chefio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

data class ZaprosRecipe(
            val id: Int,
            val name: String,
            val picture: String,
            val description: String,
            val ingredients: String,
            val stepJson: String,
            val duration: Int,
        )