package ru.kmept.chefio.singUp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.kmept.chefio.R

class UsersAdapter: RecyclerView.Adapter<UserViewHolder>()   {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
}
    override fun getItemCount(): Int {

        return 3
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

    }
}