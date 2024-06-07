package ru.kmept.chefio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotifyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // получаем ссылку на RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Создаем Adapter и привязываем его к RecyclerView
        val adapter = NotifyAdapter()
        recyclerView.adapter = adapter

        // Создаем LayoutManager и привязываем его к RecyclerView
        // LinearLayoutManager значит что ячейки будут располагаться вертикально последовательно
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}