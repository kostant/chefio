package ru.kmept.chefio
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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

class newscreen: AppCompatActivity(), Callback<RecipeResponse> {
    private lateinit var ingredientContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)

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
                if (model.token_status == "OK") {
// Токен валиден, можно сохранить его и перейти на главный экран
// Сохранить токен, например в SharedPreferences
                    val sharedPref = getSharedPreferences("chefio", Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putString("token", model.token_status)
                        apply()
                    }
// Перейти на главный экран
                    val mainIntent = Intent(this, MainActivity::class.java)
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
        public fun onclicktoback(view: View) {
            var sec = Intent(this, creare_first_step::class.java)
            startActivity(sec);
        }

        public fun onclicktomain(view: View) {
            var sec = Intent(this, MainActivity::class.java)
            startActivity(sec);
        }


    }