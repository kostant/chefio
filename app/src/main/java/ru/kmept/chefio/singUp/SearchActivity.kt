package ru.kmept.chefio.singUp

import SearchHistoryAdapter
import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.R

class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_screen) // inflate the layout

        recyclerView = findViewById(R.id.search_history_recyclerview) // now you can find the view
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = SearchHistoryAdapter()
        recyclerView.adapter = adapter
    }
}