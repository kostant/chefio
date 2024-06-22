package ru.kmept.chefio

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.internal.threadName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kmept.chefio.data.NotificationsRepository
import ru.kmept.chefio.singUp.RetrofitClient
import ru.kmept.chefio.singUp.User


class Recepie() : Fragment(), Callback<Array<RecipeDB>> {
    val adapter = RecipeAdapter()
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

        recyclerView.adapter = adapter

        // Создаем LayoutManager и привязываем его к RecyclerView
        // LinearLayoutManager значит что ячейки будут располагаться вертикально последовательно
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        RetrofitClient.apiService.Allrecipe().enqueue(this)

    }

    override fun onResponse(call: Call<Array<RecipeDB>>, response: Response<Array<RecipeDB>>) {
        val model_recepie = response.body()
        if (model_recepie != null) {
            adapter.recipes = model_recepie
            adapter.notifyDataSetChanged()
            Log.d("KMEPT", model_recepie.size.toString())
            Log.d("KMEPT", model_recepie.last().name.toString())
        }
    }

    override fun onFailure(call: Call<Array<RecipeDB>>, t: Throwable) {
        TODO("Not yet implemented")
    }
}







