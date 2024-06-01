package ru.kmept.chefio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framentsContainer, RecipeDetailsFragment())
            .commit()
    }

    fun onNotificationsClick(view: View) {
        val button: LinearLayout = findViewById(R.id.onNotificationsClickID)
        button.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)


        }
    }}