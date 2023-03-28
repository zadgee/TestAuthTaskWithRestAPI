package screens.homescreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tesktaskauth.R
import retrofit.models.ItemsMenu
import javax.inject.Inject

class HomeRecView @Inject constructor(private val context:Context,private val view:View):RecyclerView.Adapter<HomeRecView.HomeViewHolder>() {
    var itemslist = ArrayList<ItemsMenu>()
    class HomeViewHolder(view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.menulayout,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemslist.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.catalogtext).text = itemslist[position].name
        Glide.with(context).load(itemslist[position].image).into(holder.itemView.findViewById(R.id.menuitem))
        holder.itemView.findViewById<ImageView>(R.id.menuitem).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_catalogFragment)
        }
    }
    fun setlist(list: List<ItemsMenu>){
        itemslist.addAll(list)
            notifyDataSetChanged()
    }
}