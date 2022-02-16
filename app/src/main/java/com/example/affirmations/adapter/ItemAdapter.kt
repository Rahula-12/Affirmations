package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmations
import com.example.affirmations.onItemClicked

class ItemAdapter(private val context: Context,
                  private val dataset:List<Affirmations>,private val itemClicked: onItemClicked)
    :RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val imageView:ImageView=view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.itemView.setOnClickListener{
            itemClicked.showToast(dataset[holder.adapterPosition].stringResourceId)
        }
    }

    override fun getItemCount()=dataset.size

}