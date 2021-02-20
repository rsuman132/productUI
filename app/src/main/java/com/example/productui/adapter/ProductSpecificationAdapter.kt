package com.example.productui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.example.productui.R
import com.example.productui.model.ProductSpecs

class ProductSpecificationAdapter(val context: Context, var specList :ArrayList<ProductSpecs>):
        RecyclerView.Adapter<ProductSpecificationAdapter.ProductSpecificationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductSpecificationAdapter.ProductSpecificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.specification_recyclerview_list, parent, false)
        return ProductSpecificationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return specList.size
    }

    override fun onBindViewHolder(holder: ProductSpecificationAdapter.ProductSpecificationViewHolder, position: Int) {
        val item = specList[position]
        holder.which_specification.text = item.spectype
        holder.specification_name.text = item.specName

        val margin = dpToPx(1)
        val bottomMargin = margin.toInt()

        val another_margin = dpToPx(0)
        val adjusentMargin = another_margin.toInt()

        //remove the last bottom margin of the recyclerview

        if (position != itemCount-1){
            val layoutParams = holder.cardView.layoutParams as FrameLayout.LayoutParams
            layoutParams.bottomMargin = bottomMargin
            holder.cardView.layoutParams = layoutParams
        } else {
            val layoutParams = holder.cardView.layoutParams as FrameLayout.LayoutParams
            layoutParams.bottomMargin = adjusentMargin
            holder.cardView.layoutParams = layoutParams
        }
    }

    inner class ProductSpecificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardView : CardView = itemView.findViewById(R.id.specification_card_view)
        val which_specification : TextView = itemView.findViewById(R.id.which_specification)
        val specification_name : TextView = itemView.findViewById(R.id.specification_name)

    }

    //dp to px

    private fun dpToPx(dp: Int) : Float {
        val px = dp * context.resources.displayMetrics.density
        return px
    }

}