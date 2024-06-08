import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.R

class SearchHistoryAdapter : RecyclerView.Adapter<SearchHistoryAdapter.SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_activity, parent, false)
        return SearchViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        // логика конфигурации ячейки
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // инициализация view holder
    }
}