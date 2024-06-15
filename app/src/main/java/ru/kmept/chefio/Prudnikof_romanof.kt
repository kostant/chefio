package ru.kmept.chefio

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kmept.chefio.models.ErrorResponse
import ru.kmept.chefio.singUp.SignUpActivity
import java.io.Reader

class PrudnikovActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonSignUp: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autorization_activity)

        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)

        editTextEmail = findViewById(R.id.emailOrPhone)
        editTextPassword = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.loginButton)
        buttonSignUp = findViewById(R.id.signUpText1)

        checkIfLoggedIn()

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        buttonSignUp.setOnClickListener {
            onSignUpClick(it)
        }
    }

    private fun checkIfLoggedIn() {
        val token = sharedPreferences.getString("auth_token", null)
        if (token != null && token.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun onSignUpClick(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun loginUser(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        RetrofitInstance.api.loginUser(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val tokenw = response.body()?.token
                    if (tokenw != null) {
                        Log.d("token", tokenw)
                        saveAuthToken(tokenw)
                        val intent = Intent(this@PrudnikovActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    val errorResponse = parseError(response)
                    Toast.makeText(this@PrudnikovActivity, errorResponse.message, Toast.LENGTH_SHORT).show()
                    Log.d("response_error", errorResponse.message)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@PrudnikovActivity, "Ошибка сети: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("network_error", t.message.toString())
            }
        })
    }

    private fun parseError(response: Response<*>): ErrorResponse {
        val gson = Gson()
        val type = object : TypeToken<ErrorResponse>() {}.type
        val errorBody: ResponseBody? = response.errorBody()
        val reader: Reader? = errorBody?.charStream()
        return gson.fromJson(reader, type)
    }

    private fun saveAuthToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("auth_token", token)
            apply()
        }
    }
}