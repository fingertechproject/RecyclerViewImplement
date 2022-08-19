package com.example.recyclerviewimplement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context: Context,private val items:List<Articles>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item = items[position]
        holder.titleText.text = item.title
        holder.descText.text = item.description

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){
    val imageView:ImageView = view.findViewById(R.id.image)
    val titleText:TextView = view.findViewById(R.id.title)
    val descText:TextView  = view.findViewById(R.id.description)
}