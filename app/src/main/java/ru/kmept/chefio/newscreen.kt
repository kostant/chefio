package ru.kmept.chefio

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class newscreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)
    }
    public fun on_click_next(view:View)
    {
        var i:Intent = Intent(this, CreateActivity::class.java)
        startActivity(i);
    }
}