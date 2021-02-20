package com.example.productui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productui.R
import com.example.productui.model.ProductReview

class ReviewAdapter(private val reviewList : ArrayList<ProductReview>): RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_page_list, parent, false)
        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    override fun onBindViewHolder(holder: ReviewAdapter.ReviewViewHolder, position: Int) {
        val item = reviewList[position]
        holder.reviewer_name.text = item.reviewerName
        holder.reviewer_image.setImageResource(item.reviewerImage)
        holder.reviewer_rating.rating = item.reviewerRating
        holder.reviewer_date.text = item.reviewed_date
        holder.review_product.text = item.review_content
    }

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val reviewer_image : ImageView = itemView.findViewById(R.id.reviewer_image)
        val reviewer_name : TextView = itemView.findViewById(R.id.reviewer_name)
        val reviewer_rating : RatingBar = itemView.findViewById(R.id.reviewer_rating)
        val reviewer_date : TextView = itemView.findViewById(R.id.reviewer_date)
        val review_product : TextView = itemView.findViewById(R.id.review_product)
    }
}