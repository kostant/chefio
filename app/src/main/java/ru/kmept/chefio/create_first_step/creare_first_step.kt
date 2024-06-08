package ru.kmept.chefio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class creare_first_step : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_create_first_step)
    }

    public fun onclicktosecond(view: View)
    {
        var sec = Intent(this, newscreen::class.java)
        startActivity(sec);
    }
    public fun onclicktomain(view: View)
    {
        var sec = Intent(this, MainActivity::class.java)
        startActivity(sec);
    }
}