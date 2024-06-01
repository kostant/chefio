package ru.kmept.chefio

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_screen)


    }
    public fun on_click(view: View)
    {
    var i =Intent(this,creare_first_step::class.java)
        startActivity(i)
    }
}