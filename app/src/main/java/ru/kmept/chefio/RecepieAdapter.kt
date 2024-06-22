package ru.kmept.chefio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.data.model.Notification
import ru.kmept.kormezhka.data.model.Recipe

class RecipeAdapter() :
    RecyclerView.Adapter<RecipeViewHolder>() {

    var recipes: Array<RecipeDB> = emptyArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recepie_list, parent, false)
        return RecipeViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.recipeName.text = recipe.name
//        holder.recipeAuthor.text = recipe.author.toString()
//        holder.recipeImage.setImageResource(R.drawable.pankake)



    }


    override fun getItemCount(): Int = recipes.size
}