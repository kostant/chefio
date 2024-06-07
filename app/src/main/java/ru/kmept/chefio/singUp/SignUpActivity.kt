package ru.kmept.chefio.singUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kmept.chefio.R
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class SignUpActivity : AppCompatActivity()  {

//    var input_login:TextView = findViewById(R.id.editTextEmailAndNumber)

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
                    isCorrectCount = false
                    Log.d("PPPPPPPPPPPPPPPPP", "NOT COUNT");
                }
                else{
                    check_count_character.setImageResource(R.drawable.check_green)
                    isCorrectCount = true
                    Log.d("PPPPPPPPPPPPPPPPP", "YES COUNT");
                }

                if (s.toString().any { it.isDigit() }) {
                    check_number.setImageResource(R.drawable.check_green)
                    isCorrectNumber = true
                    Log.d("PPPPPPPPPPPPPPPPP", "YES NUMBER");
                } else {
                    check_number.setImageResource(R.drawable.check_gray)
                    isCorrectNumber = false
                    Log.d("PPPPPPPPPPPPPPPPP", "NOT NUMBER");
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if(isCorrectCount == true && isCorrectNumber == true){
                    isCorrectPassword = true
                } else {
                    isCorrectPassword = false
                }
            }
        })
    }

    fun onClick(view:View){

        var signUpButton:Button = findViewById(R.id.signUpButton)

        var input_login:TextView = findViewById(R.id.editTextEmailAndNumber)
        var input_password:TextView = findViewById(R.id.editTextPassword)

        if(isCorrectPassword)
        {
            sendPostRequest(input_login.text.toString(), input_password.text.toString())
        }
        else if(!isCorrectPassword)
        {
            Log.d("PPPPPPPPPPPPPPPPP", "ERROR PASSWORD");
            if(!isCorrectCount && !isCorrectNumber){
                Toast.makeText(this, "The password is too weak.", Toast.LENGTH_SHORT).show()
            }
            else if(!isCorrectCount){
                Toast.makeText(this, "Your password is too short.", Toast.LENGTH_SHORT).show()
            }
            else if(!isCorrectNumber){
                Toast.makeText(this, "Your password must have one digit.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun sendPostRequest(input_login:String, input_password:String) {
        val user = User(login = input_login, password = input_password)
        val call = RetrofitClient.apiService.createUser(user)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Запрос успешен, обработайте ответ
                    Log.d("Retrofit", "Response: ${response.body()?.string()}")
                } else {
                    // Обработка ошибки
                    Log.d("Retrofit", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // Обработка ошибки сети или других проблем
                Log.d("Retrofit", "Failure: ${t.message}")
            }
        })
    }
}