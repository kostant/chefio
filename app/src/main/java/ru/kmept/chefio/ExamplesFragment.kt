package ru.kmept.chefio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.kmept.chefio.data.NotificationsRepository
import ru.kmept.chefio.data.model.Notification

class ExamplesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Вместо R.layout.activity_main указываем файл с версткой вашего экрана
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NotificationsRepository().getAllNotifications {
            updateScreenWithData(it)
        }
    }

    fun updateScreenWithData(notifications: Array<Notification>) {
        // обновляем экран данными которые лежат в массиве notifications
    }
}