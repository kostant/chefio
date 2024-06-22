package ru.kmept.chefio

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotifyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val avatarImageView: ImageView
    val nameTextView: TextView
    val followButton: Button
    init {
        avatarImageView = itemView.findViewById(R.id.avatarImageView)
        nameTextView = itemView.findViewById(R.id.nameTextView)

        followButton = itemView.findViewById(R.id.followButton)
    }
}