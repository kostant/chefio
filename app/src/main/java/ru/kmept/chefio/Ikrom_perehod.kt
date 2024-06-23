package ru.kmept.chefio


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import ru.kmept.chefio.PrudnikovActivity
import ru.kmept.chefio.R

public class Perehod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.perehod)

    }
    public fun on_click_get_started(view:View)
    {
        var i:Intent = Intent(this,PrudnikovActivity::class.java);
        startActivity(i)
    }

}
