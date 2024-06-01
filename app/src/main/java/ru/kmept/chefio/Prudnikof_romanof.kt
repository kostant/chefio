package ru.kmept.chefio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.kmept.chefio.singUp.SignUpActivity

class prudnikov : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autorization_activity)


        // Метод для обработки клика на текст "Sign Up"
        fun onSignUpClick(view: View) {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}