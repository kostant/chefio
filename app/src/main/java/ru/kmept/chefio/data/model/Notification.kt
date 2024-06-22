package ru.kmept.chefio.data.model

import java.util.Date

data class Notification(
    val name: String,
    val avatarUrl: String?,
    val date: Date,
    val isFollowed: Boolean
)