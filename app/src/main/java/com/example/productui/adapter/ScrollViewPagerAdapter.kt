package com.example.productui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.productui.R
import com.example.productui.model.ImageList

class ScrollViewPagerAdapter(var context: Context, var imageList: ArrayList<ImageList>) : RecyclerView.Adapter<ScrollViewPagerAdapter.ScrollImageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScrollViewPagerAdapter.ScrollImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scroll_images_list, parent, false)
        return ScrollImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(
            holder: ScrollViewPagerAdapter.ScrollImageViewHolder,
            position: Int
    ) {
        val item = imageList[position]
        holder.scroll_images.setImageResource(item.viewPagerImage)
    }

     inner class ScrollImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val scroll_images : ImageView = itemView.findViewById(R.id.scroll_images)
     }
}