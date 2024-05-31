package ru.kmept.chefio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ProfileBut = findViewById<ImageView>(R.id.profile_but)

            ProfileBut.setOnClickListener{
                val intnet = Intent(this, Profile::class.java)
                startActivity(intent)


            }



    }
}