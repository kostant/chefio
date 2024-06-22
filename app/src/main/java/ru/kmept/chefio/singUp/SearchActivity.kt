package ru.kmept.chefio.singUp

import SearchHistoryAdapter
import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.Profile
import ru.kmept.chefio.R

@Suppress("DEPRECATION")
class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchHistoryAdapter
    private lateinit var BackBut: View // инициализируйте переменную здесь

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_screen) // inflate the layout

        recyclerView = findViewById(R.id.search_history_recyclerview) // now you can find the view
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = SearchHistoryAdapter()
        recyclerView.adapter = adapter

        BackBut = findViewById<View>(R.id.strelkanazad)
        BackBut.setOnClickListener {
            onBackPressed()
        }
    }
}




