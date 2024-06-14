package ru.kmept.chefio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.kormezhka.data.model.Recipe

class Recepie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resaiklervirerecepie)

        // получаем ссылку на RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerviewrecepie)

        // Создаем список рецептов


        // Создаем Adapter и привязываем его к RecyclerView
        val adapter = RecipeAdapter()
        recyclerView.adapter = adapter

        // Создаем LayoutManager и привязываем его к RecyclerView
        // LinearLayoutManager значит что ячейки будут располагаться вертикально последовательно
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

}