package ru.kmept.chefio

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framentsContainer, RecipeDetailsFragment())
            .commit()

        val ProfileBut = findViewById<View>(R.id.profile_but)

        ProfileBut.setOnClickListener{
            val intnet = Intent(this, Profile::class.java)
            startActivity(intnet)


        }
    }

    public fun on_click(view: View)
    {
        var i =Intent(this,creare_first_step::class.java)
        startActivity(i)
    }
}