package screens.catalogscreen
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tesktaskauth.R
import retrofit.models.BrandItems
import javax.inject.Inject

class CatalogRecView@Inject constructor(private val context:Context):RecyclerView.Adapter<CatalogRecView.CatalogViewHolder>() {
    var listwithbrands = ArrayList<BrandItems>()
    class CatalogViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brands_items_layout,parent,false)
        return CatalogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listwithbrands.size
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        Glide.with(context).load(listwithbrands[position].apple.image).into(holder.itemView.findViewById(R.id.imagebrand))
        Glide.with(context).load(listwithbrands[position].samsung.image).into(holder.itemView.findViewById(R.id.samsungimage))
        holder.itemView.findViewById<TextView>(R.id.appletext).text = listwithbrands[position].apple.name
        holder.itemView.findViewById<TextView>(R.id.samsungtext).text = listwithbrands[position].samsung.name
    }

    fun createbrandslist(list: List<BrandItems>){
        listwithbrands.addAll(list)
        notifyDataSetChanged()
    }
}