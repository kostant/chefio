package ru.kmept.chefio.singUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.kmept.chefio.R

class SignUpActivity : AppCompatActivity()  {

    var isCorrectCount = false
    var isCorrectNumber = false

    var isCorrectPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var input_password:TextView = findViewById(R.id.editTextPassword)
        var check_count_character:ImageView = findViewById(R.id.check_count_character)
        var check_number:ImageView = findViewById(R.id.check_number)

        input_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var character = input_password.length()

                if(character < 6){
                    check_count_character.setImageResource(R.drawable.check_gray)
                    isCorrectCount = true
                }
                else{
                    check_count_character.setImageResource(R.drawable.check_green)
                    isCorrectCount = false
                }

                if (s.toString().any { it.isDigit() }) {
                    check_number.setImageResource(R.drawable.check_green)
                    isCorrectNumber = true
                } else {
                    check_number.setImageResource(R.drawable.check_gray)
                    isCorrectNumber = false
                }

                if(isCorrectCount == true && isCorrectNumber == true){
                    isCorrectPassword = true
                } else {
                    isCorrectPassword = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    public fun onClick(view:View){
        
    }
}