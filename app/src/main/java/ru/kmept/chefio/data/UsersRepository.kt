package ru.kmept.kormezhka.data

import ru.kmept.kormezhka.data.model.User

class UsersRepository {
    fun random(): User {
        return User(
            id = 1,
            name = "Calum Lewis",
            avatarUrl = "https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250"
        )
    }
}