package ru.kmept.chefio

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        //holder.recipeAuthor.text = recipe.author.toString()
        //holder.recipeImage.imageAlpha = recipe.picture
        holder.recipeTime.text = recipe.duration.toString()


        Picasso.get()
            .load(recipe.picture)
            .into(holder.recipeImage)





    }




    override fun getItemCount(): Int = recipes.size
}