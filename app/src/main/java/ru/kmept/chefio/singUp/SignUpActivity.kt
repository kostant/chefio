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

                if(checkCountPassword(character)){
                    check_count_character.setImageResource(R.drawable.check_green)
                }
                else{
                    check_count_character.setImageResource(R.drawable.check_gray)
                }

                if(checkNumberPassword(s)){
                    check_number.setImageResource(R.drawable.check_green)
                    Log.d("PPPPPPPPPPPPPPPPP", "YES NUMBER");
                }
                else{
                    check_number.setImageResource(R.drawable.check_gray)
                    Log.d("PPPPPPPPPPPPPPPPP", "NOT NUMBER");
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    fun onClick(view:View){
        var input_login:TextView = findViewById(R.id.editTextEmailAndNumber)
        var input_password:TextView = findViewById(R.id.editTextPassword)

        val char: CharSequence = input_password.text

        var character = input_password.length()

        if(checkCountPassword(character) && checkNumberPassword(char))
        {
            sendPostRequest(input_login.text.toString(), input_password.text.toString())
        }
        else if(!checkCountPassword(character) || !checkNumberPassword(char))
        {
            Log.d("PPPPPPPPPPPPPPPPP", "ERROR PASSWORD");
            if(!checkCountPassword(character) && !checkNumberPassword(char)){
                Toast.makeText(this, "The password is too weak.", Toast.LENGTH_SHORT).show()
            }
            else if(!checkCountPassword(character)){
                Toast.makeText(this, "Your password is too short.", Toast.LENGTH_SHORT).show()
            }
            else if(!checkNumberPassword(char)){
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
//                    Log.d("Retrofit", "Response: ${response.body()?.string()}")

                    // Запрос успешен, обработайте ответ
                    val responseBody = response.body()?.string()
                    val jsonObject = JSONObject(responseBody)
                    val regStatus = jsonObject.getInt("regStatus")

                    if (regStatus == 0) {
                        // Обрабатываем ошибку
                        Log.d("Retrofit", "Регистрация не удалась")
                        Toast.makeText(this@SignUpActivity, "There is already such a user.", Toast.LENGTH_SHORT).show()
                    } else {
                        // Обрабатываем успех
                        Log.d("Retrofit", "Регистрация успешна")
                    }
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

    fun checkCountPassword(character:Int):Boolean {
        if(character < 6){
            Log.d("PPPPPPPPPPPPPPPPP", "NOT COUNT");
            return false
        }
        else{
            Log.d("PPPPPPPPPPPPPPPPP", "YES COUNT");
            return true
        }
    }

    fun checkNumberPassword(input_password:CharSequence?):Boolean {
        return input_password.toString().any { it.isDigit() }
    }
}

//    Toast.makeText(this, "There is already such a user.", Toast.LENGTH_SHORT).show()
