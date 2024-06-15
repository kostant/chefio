package ru.kmept.chefio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.data.NotificationsRepository
import ru.kmept.kormezhka.data.model.Recipe


class Recepie: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.resaiklervirerecepie, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerviewrecepie)

        // Создаем Adapter и привязываем его к RecyclerView
        val adapter = RecipeAdapter()
        recyclerView.adapter = adapter

        // Создаем LayoutManager и привязываем его к RecyclerView
        // LinearLayoutManager значит что ячейки будут располагаться вертикально последовательно
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        NotificationsRepository.global.getAllNotifications {
            adapter.notifications = it
            adapter.notifyDataSetChanged()

        }
    }
}




//class Recepie : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.resaiklervirerecepie)
//
//        // получаем ссылку на RecyclerView
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerviewrecepie)
//
//
//
//        // Создаем Adapter и привязываем его к RecyclerView
//        val adapter = RecipeAdapter()
//        recyclerView.adapter = adapter
//
//        // Создаем LayoutManager и привязываем его к RecyclerView
//        // LinearLayoutManager значит что ячейки будут располагаться вертикально последовательно
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//    }
//
//}