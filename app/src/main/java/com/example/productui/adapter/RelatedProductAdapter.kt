package com.example.productui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productui.R
import com.example.productui.model.RelatedProduct

class RelatedProductAdapter(val context: Context, val relatedList : ArrayList<RelatedProduct>) : RecyclerView.Adapter<RelatedProductAdapter.RelatedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedProductAdapter.RelatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.related_product_list, parent, false)
        return RelatedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return relatedList.size
    }

    override fun onBindViewHolder(holder: RelatedProductAdapter.RelatedViewHolder, position: Int) {
        val item = relatedList[position]
        holder.related_text.text = item.related_Title
        holder.related_price.text = item.related_Price
        holder.related_image.setImageResource(item.related_Image)
    }

    inner class RelatedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val related_image : ImageView = itemView.findViewById(R.id.related_image)
        val related_text : TextView = itemView.findViewById(R.id.related_text)
        val related_price : TextView = itemView.findViewById(R.id.related_price)
    }
}