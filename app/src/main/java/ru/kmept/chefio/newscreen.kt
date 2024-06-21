package ru.kmept.chefio
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kmept.chefio.singUp.RetrofitClient
import ru.kmept.kormezhka.data.model.Recipe

class newscreen: AppCompatActivity(), Callback<RecipeResponse> {
    private lateinit var ingredientContainer: LinearLayout
    private lateinit var sharedPreferences: SharedPreferences
    var progress1 = 0;
    lateinit var name: String
    lateinit var description: String
    lateinit var ingridients: String
    lateinit var step: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        progress1 = intent.getIntExtra("progress", 0)
        name = intent.getStringExtra("name").toString()
        description = intent.getStringExtra("description").toString()

    }


    override fun onResponse(
        call: Call<RecipeResponse>,
        response: Response<RecipeResponse>
    ) {
        val model = response.body()
        if (model != null) {
            val model = response.body()
            if (model != null) {
// Проверить статус токена
                if (model.token_status == "sucess_code_202") {
// Токен валиден, можно сохранить его и перейти на главный экран
// Сохранить токен, например в SharedPreferences
                    val sharedPref = getSharedPreferences("chefio", Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putString("token", model.token_status)
                        apply()
                    }
// Перейти на главный экран
                    val mainIntent = Intent(this, CreateActivity::class.java)
                    startActivity(mainIntent)
                } else {
// Токен не валиден, показать сообщение об ошибке
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Токен не валиден")
                        .setPositiveButton("OK", null)
                        .create()
                    dialog.show()
                }
            }
        }
    }

    override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Ошибка")
            .setMessage("Ошибка загрузки рецепта")
            .setPositiveButton("OK", null)
            .create()
        dialog.show()
    }
    fun onClickFinal(view: View) {
        val token = sharedPreferences.getString("auth_token",null).toString()
        if(token.length > 0) {
            ingridients = findViewById<EditText>(R.id.food_ingridients).text.toString()
            step = findViewById<EditText>(R.id.food_step).text.toString()
            val recipe = ZaprosRecipe(
                token,
                name, "null", description, ingridients, step, progress1
            )
            RetrofitClient.apiService.GetRecipe(recipe).enqueue(this)
        }
    }
        public fun onclicktoback(view: View) {
            var sec = Intent(this, creare_first_step::class.java)
            startActivity(sec);
        }

        public fun onclicktomain(view: View) {
            var sec = Intent(this, MainActivity::class.java)
            startActivity(sec);
        }


    }