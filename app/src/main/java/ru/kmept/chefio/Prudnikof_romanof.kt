package ru.kmept.chefio

import android.content.Intent
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
    public fun login_click(view:View)
    {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autorization_activity)
        editTextEmail = findViewById(R.id.emailOrPhone)
        editTextPassword = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.loginButton)
        buttonSignUp = findViewById(R.id.signUpText1)

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

    fun onSignUpClick(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun loginUser(username: String, password: String):String {
        val loginRequest = LoginRequest(username, password)
        var token = ""
        RetrofitInstance.api.loginUser(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val tokenw = response.body()?.token
                    if (tokenw != null) {

                        Log.d("token",tokenw.toString())

                        token = tokenw
                        if(token.length > 0)
                        {
                            val intent = Intent(this@PrudnikovActivity, recipeAcrivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val errorResponse = parseError(response)
                    Toast.makeText(this@PrudnikovActivity, errorResponse.message, Toast.LENGTH_SHORT).show()
                    Log.d("sss", errorResponse.message)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@PrudnikovActivity, "Ошибка сети: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("ssrs", t.message.toString())
            }
        })
        return token
    }

    private fun parseError(response: Response<*>): ErrorResponse {
        val gson = Gson()
        val type = object : TypeToken<ErrorResponse>() {}.type
        val errorBody: ResponseBody? = response.errorBody()
        val reader: Reader? = errorBody?.charStream()
        return gson.fromJson(reader, type)
    }

    private fun saveAuthToken(token: String) {
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("auth_token", token)
        editor.apply()
    }
}