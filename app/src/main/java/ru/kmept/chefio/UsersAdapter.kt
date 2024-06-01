package ru.kmept.chefio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class UsersAdapter: RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Здесь необходимо создать ViewHolder используя файл верстки
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.notification_window, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // Тут необходимо вернуть число - количество ячеек в таблице,
        // пока возвращаем заглушку - 10
        return 10
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // Здесь будет логика, которая будет конфигурировать конкретную ячейку и выставлять
        // нужную аватарку имя и тд
        // Пока оставляем пустым
    }
}