package ru.kmept.chefio.singUp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import ru.kmept.chefio.Profile
import ru.kmept.chefio.R

class ProfileFragment : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prof_but = findViewById<LinearLayout>(R.id.profile_but)

        prof_but.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}