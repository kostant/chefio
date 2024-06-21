package ru.kmept.chefio
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
class newscreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)
        val button = findViewById<Button>(R.id.NextButton)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_window, null)
            builder.setView(dialogLayout)

            val dialog = builder.create()
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

    }

}