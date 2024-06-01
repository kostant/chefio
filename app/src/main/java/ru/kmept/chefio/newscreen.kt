package ru.kmept.chefio
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
class newscreen: AppCompatActivity() {
    private lateinit var ingredientContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newscreen)
        val button = findViewById<Button>(R.id.NextButton)

        ingredientContainer = findViewById(R.id.ingredient_container)

        val addIngredientButton = findViewById<Button>(R.id.add_ingredient_button)
        addIngredientButton.setOnClickListener {
            addIngredientField()
        }


        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_window, null)
            builder.setView(dialogLayout)

            val dialog = builder.create()
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
    }

    fun addIngredientField() {
        val ingredientField = layoutInflater.inflate(R.layout.maketforingridients, null)
        ingredientContainer.addView(ingredientField)
    }

    public fun onclicktoback(view: View)
    {
        var sec = Intent(this, creare_first_step::class.java)
        startActivity(sec);
    }
    public fun onclicktomain(view: View)
    {
        var sec = Intent(this, MainActivity::class.java)
        startActivity(sec);
    }

}