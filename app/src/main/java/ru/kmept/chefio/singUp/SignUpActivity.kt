package ru.kmept.chefio.singUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.kmept.chefio.R

class SignUpActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var input_password:TextView = findViewById(R.id.editTextPassword)
        var check_count_character:ImageView = findViewById(R.id.check_count_character)

        input_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var character = input_password.length()

                if(character < 6){
                    check_count_character.setImageResource(R.drawable.check_gray)
                }
                else{
                    check_count_character.setImageResource(R.drawable.check_green)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}