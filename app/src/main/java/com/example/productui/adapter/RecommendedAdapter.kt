package com.example.productui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.example.productui.R
import com.example.productui.model.RecommendProduct

class RecommendedAdapter(val recommendList: ArrayList<RecommendProduct>)
    : RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedAdapter.RecommendedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommented_product_recyclerview_list, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recommendList.size
    }

    override fun onBindViewHolder(holder: RecommendedAdapter.RecommendedViewHolder, position: Int) {
        val item = recommendList[position]
        holder.recommended_image.setImageResource(item.recommendImage)
        holder.recommended_price.text = item.recommendPrice
        holder.recommended_title.text = item.recommendTitle

    }

    inner class RecommendedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val recommended_image : ImageView = itemView.findViewById(R.id.recommended_image)
        val recommended_title : TextView = itemView.findViewById(R.id.recommended_title)
        val recommended_price : TextView = itemView.findViewById(R.id.recommended_price)
    }

}