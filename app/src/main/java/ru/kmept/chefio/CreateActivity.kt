package ru.kmept.chefio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_window)

    }
    public fun onclicktomain(view: View)
    {
        var sec = Intent(this, MainActivity::class.java)
        startActivity(sec);
    }

}