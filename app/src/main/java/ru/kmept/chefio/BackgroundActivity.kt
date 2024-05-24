package ru.kmept.chefio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class BackgroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.background_screen)
        val button = findViewById<Button>(R.id.But1)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.activity_main, null)
            builder.setView(dialogLayout)
            val dialog = builder.create()
            dialog.show()
        }


    }

}