package ru.kmept.chefio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framentsContainer, RecipeDetailsFragment())
            .commit()

        val ProfileBut = findViewById<View>(R.id.profile_but)
        val HomeBut = findViewById<View>(R.id.home_but)

        ProfileBut.setOnClickListener{

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, Profile())
                .commit()

        }
        HomeBut.setOnClickListener{

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, RecipeDetailsFragment())
                .commit()

        }
    }
    }



//    public fun on_click(view: View)
//    {
//        var i =Intent(this,creare_first_step::class.java)
//        startActivity(i)
//    }

