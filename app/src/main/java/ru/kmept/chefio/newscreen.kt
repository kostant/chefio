package ru.kmept.chefio
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
class newscreen: AppCompatActivity() {
    private lateinit var ingredientContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)
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