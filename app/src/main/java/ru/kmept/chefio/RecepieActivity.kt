package ru.kmept.chefio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RecepieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recepie_list)

        val fragment = Recepie()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}