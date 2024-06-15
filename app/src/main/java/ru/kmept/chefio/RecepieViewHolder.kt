package ru.kmept.chefio

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val recipeImage: ImageView = itemView.findViewById(R.id.recipe_image)
    val recipeName: TextView = itemView.findViewById(R.id.recipe_name)
    val recipeTime: TextView = itemView.findViewById(R.id.recipe_time)
    val recipeAuthor: TextView = itemView.findViewById(R.id.recipe_author)
    val recipeFavorite: ImageView = itemView.findViewById(R.id.recipe_favorite)
}