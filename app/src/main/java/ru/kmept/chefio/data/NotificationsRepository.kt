package ru.kmept.chefio.data

import ru.kmept.chefio.data.model.Notification
import java.util.Date

class NotificationsRepository {
    fun getAllNotifications(completion: (Array<Notification>) -> Unit) {
        val mockData = arrayOf(
            Notification(
                "Dean Winchester",
                "https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250",
                Date(2024, 4, 25),
                false
            ),
            Notification(
                "John Steve",
                "https://i.pravatar.cc/250?u=mail@ashallendesign.co.uk",
                Date(2024, 3, 11),
                true
            ),
            Notification(
                "Sam Winchester",
                "https://avatar.iran.liara.run/public/boy?username=Ash",
                Date(2024, 2, 22),
                true
            ),
            Notification(
                "Dean Aleman",
                "https://api.dicebear.com/7.x/adventurer-neutral/svg?seed=mail@ashallendesign.co.uk",
                Date(2024, 1, 1),
                false
            )
        )

        completion(mockData)
    }
}