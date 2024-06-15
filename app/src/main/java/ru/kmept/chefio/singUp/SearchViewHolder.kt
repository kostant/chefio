import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.kmept.chefio.R

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ClockImageView: ImageView
    val StrelkaImageView: ImageView
    val nameTextView: TextView
    init {
        ClockImageView = itemView.findViewById(R.id.clock)
        StrelkaImageView = itemView.findViewById(R.id.strelkavverh)
        nameTextView = itemView.findViewById(R.id.searchdtext)
    }
}