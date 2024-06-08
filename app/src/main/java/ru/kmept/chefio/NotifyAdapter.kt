    package ru.kmept.chefio

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import ru.kmept.chefio.data.model.Notification


    class NotifyAdapter: RecyclerView.Adapter<NotifyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifyViewHolder {
            // Здесь необходимо создать ViewHolder используя файл верстки
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.notification_window, parent, false)
            return NotifyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            // Тут необходимо вернуть число - количество ячеек в таблице,
            // пока возвращаем заглушку - 10
            return notifications.size
        }

        override fun onBindViewHolder(holder: NotifyViewHolder, position: Int) {
            // Здесь будет логика, которая будет конфигурировать конкретную ячейку и выставлять
            // нужную аватарку имя и тд
            // Пока оставляем пустым
        }

            var notifications: Array<Notification> = emptyArray()
        }
