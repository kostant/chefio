package ru.kmept.chefio

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class BackgroundActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.background_screen)
        val button = findViewById<Button>(R.id.But1)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_window, null)
            builder.setView(dialogLayout)
            val dialog = builder.create()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()
        }
    }
}