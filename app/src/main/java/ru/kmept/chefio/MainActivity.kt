package ru.kmept.chefio

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import ru.kmept.chefio.singUp.SearchActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framentsContainer, RecipeDetailsFragment())
            .commit()

        val ProfileBut = findViewById<View>(R.id.profile_but)
        val HomeBut = findViewById<View>(R.id.home_but)
        val ScanBut = findViewById<View>(R.id.scan_but)
        val NotifyBut = findViewById<View>(R.id.notification)
        val NotifyButLiner = findViewById<View>(R.id.onNotificationsClickID)

        ProfileBut.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, Profile())
                .commit()
                updateTabs(3)


        }
        NotifyBut.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, NotifyActivity())
                .commit()
            updateTabs(2)


        }
        NotifyButLiner.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, NotifyActivity())
                .commit()
            updateTabs(2)


        }
        HomeBut.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framentsContainer, RecipeDetailsFragment())
                .commit()
            updateTabs(1)

        }
        ScanBut.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    fun updateTabs(position: Int){
        if (position == 1){
            val imageView: ImageView = findViewById(R.id.imagehome)
            val textView: TextView = findViewById(R.id.hometext)
            imageView.setImageResource(R.drawable.greenhome)
            textView.setTextColor(Color.parseColor("#1FCC79"))
        }else{
            val imageView: ImageView = findViewById(R.id.imagehome)
            val textView: TextView = findViewById(R.id.hometext)
            imageView.setImageResource(R.drawable.home)
            textView.setTextColor(Color.parseColor("#9FA5C0"))
        }
        if (position == 2){
            val imageView: ImageView = findViewById(R.id.notification)
            val textView: TextView = findViewById(R.id.notificationtext)
            imageView.setImageResource(R.drawable.notification)
            textView.setTextColor(Color.parseColor("#1FCC79"))
        }else{
            val imageView: ImageView = findViewById(R.id.notification)
            val textView: TextView = findViewById(R.id.notificationtext)
            imageView.setImageResource(R.drawable.graynotification)
            textView.setTextColor(Color.parseColor("#9FA5C0"))
        }
        if (position == 3){
            val imageView: ImageView = findViewById(R.id.profileicon)
            val textView: TextView = findViewById(R.id.profiletext)
            imageView.setImageResource(R.drawable.greenprofile)
            textView.setTextColor(Color.parseColor("#1FCC79"))
        }else{
            val imageView: ImageView = findViewById(R.id.profileicon)
            val textView: TextView = findViewById(R.id.profiletext)
            imageView.setImageResource(R.drawable.profile)
            textView.setTextColor(Color.parseColor("#9FA5C0"))
        }
    }

    fun onNotificationsClick(view: View) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framentsContainer, NotifyActivity())
            .commit()
    }

    public fun on_click(view: View) {
        var i = Intent(this, creare_first_step::class.java)
        startActivity(i)
    }


}


