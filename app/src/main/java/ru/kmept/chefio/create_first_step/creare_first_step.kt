package ru.kmept.chefio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar

class creare_first_step : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_create_first_step)
    }

    public fun onclicktosecond(view: View)
    {
        val seekbar: SeekBar = findViewById(R.id.seekBar2)
        val progress = seekbar.progress
        val name = findViewById<EditText>(R.id.food_name).text.toString()
        val description = findViewById<EditText>(R.id.food_description).text.toString()
        // Create the Intent
        var sec = Intent(this, newscreen::class.java)

        // Add the name and description as extras
        sec.putExtra("name", name)
        sec.putExtra("description", description)
        sec.putExtra("progress", 4)

        // Start the second screen
        startActivity(sec)
    }
    public fun onclicktomain(view: View)
    {
        var sec = Intent(this, MainActivity::class.java)
        startActivity(sec);
    }
}