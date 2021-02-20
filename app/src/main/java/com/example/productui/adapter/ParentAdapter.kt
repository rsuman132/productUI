package com.example.productui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.productui.MainActivity.Companion.getProductSpecification
import com.example.productui.MainActivity.Companion.getRecommendedProduct
import com.example.productui.MainActivity.Companion.getRelatedProduct
import com.example.productui.MainActivity.Companion.getReviewedItems
import com.example.productui.MainActivity.Companion.getScrollImage
import com.example.productui.R
import com.example.productui.model.*
import com.example.productui.viewmodel.ImageListViewModel
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import kotlin.collections.ArrayList

class ParentAdapter(private val context : Context,
                    private val totalList : ArrayList<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var scrollViewPagerAdapter: ScrollViewPagerAdapter
    private lateinit var productSpecificationAdapter: ProductSpecificationAdapter
    private lateinit var recommendedAdapter: RecommendedAdapter
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var relatedProductAdapter: RelatedProductAdapter

    companion object{
        const val SCROLL_IMAGE_LIST = 0
        const val DESCRIPTION_LIST = 1
        const val NAME_LIST = 2
        const val SPECIFICATION_LIST = 3
        const val RECOMMENDED_PRODUCT_LIST = 4
        const val PRODUCT_REVIEW = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            SCROLL_IMAGE_LIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_scroll_list_with_indicator, parent, false)
                return ScrollImageViewHolder(view)
            }
            DESCRIPTION_LIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.title_rating_list, parent, false)
                return TitleRatingViewHolder(view)
            }
            NAME_LIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.description_list, parent, false)
                return DescriptionViewHolder(view)
            }
            SPECIFICATION_LIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.product_specification, parent, false)
                return ProductSpecificationViewHolder(view)
            }
            RECOMMENDED_PRODUCT_LIST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.product_recommentation, parent, false)
                return RecommendedViewHolder(view)
            }
            PRODUCT_REVIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.reviewed_page_recyclerview, parent, false)
                return ReviewViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.related_product_recyclerview, parent, false)
                return RelatedViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return totalList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            when (getItemViewType(position)){
                SCROLL_IMAGE_LIST -> {
                    val holder = holder as ScrollImageViewHolder
                    viewPager(holder)

                }
                DESCRIPTION_LIST -> {
                    val titleRating = totalList[position] as TitleRating
                    val holder = holder as TitleRatingViewHolder
                    holder.product_title.text = titleRating.productTitle
                    holder.product_no_review.text = titleRating.productReview
                    holder.product_available.text = titleRating.productAvailable

                }
                NAME_LIST -> {
                    val description = totalList[position] as Description
                    val holder = holder as DescriptionViewHolder
                    holder.item_description.text = description.commentsDesc
                }
                SPECIFICATION_LIST -> {
                    val holder = holder as ProductSpecificationViewHolder
                    productSpecification(holder)
                }
                RECOMMENDED_PRODUCT_LIST -> {
                    val recommendProduct = totalList[position] as RecommendProduct
                    val holder = holder as RecommendedViewHolder
                    recommendedProduct(holder)
                }
                PRODUCT_REVIEW -> {
                    val holder = holder as ReviewViewHolder
                    reviewedItem(holder)
                }
                else -> {
                    val holder = holder as RelatedViewHolder
                    relatedProduct(holder)
                }
            }


    //setup recyclerview type of activity
    //setup viewpager
    private fun viewPager(holder: ScrollImageViewHolder){

        //val imageList = arrayListOf<ImageList>()

        scrollViewPagerAdapter = ScrollViewPagerAdapter(context, getScrollImage())
        holder.scroll_image_view_pager.adapter = scrollViewPagerAdapter

        holder.dot_indicator.setViewPager2(holder.scroll_image_view_pager)

    }

    private fun productSpecification(holder: ProductSpecificationViewHolder){

        productSpecificationAdapter = ProductSpecificationAdapter(context, getProductSpecification())
        holder.specification_recyclerview.layoutManager = LinearLayoutManager(context)
        holder.specification_recyclerview.adapter = productSpecificationAdapter

    }

    private fun recommendedProduct(holder : RecommendedViewHolder){

        recommendedAdapter = RecommendedAdapter(getRecommendedProduct())
        holder.recommended_recyclerview.layoutManager = GridLayoutManager(context, 1,  GridLayoutManager.HORIZONTAL, false)
        holder.recommended_recyclerview.adapter = recommendedAdapter

    }

    private fun reviewedItem(holder : ReviewViewHolder){

        reviewAdapter = ReviewAdapter(getReviewedItems())
        holder.review_recyclerview.layoutManager = LinearLayoutManager(context)
        holder.review_recyclerview.adapter = reviewAdapter

    }

    private fun relatedProduct(holder: RelatedViewHolder){
        relatedProductAdapter = RelatedProductAdapter(context, getRelatedProduct())
        holder.related_recyclerview.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        holder.related_recyclerview.adapter = relatedProductAdapter

    }

    //important in heterogeneous layout

    override fun getItemViewType(position: Int): Int {
        when {
            ImageList::class.isInstance(totalList[position]) -> {
                return 0
            }
            TitleRating::class.isInstance(totalList[position]) -> {
                return 1
            }
            Description::class.isInstance(totalList[position]) -> {
                return 2
            }
            ProductSpecs::class.isInstance(totalList[position]) -> {
                return 3
            }
            RecommendProduct::class.isInstance(totalList[position]) -> {
                return 4
            }
            ProductReview::class.isInstance(totalList[position]) -> {
                return 5
            }
            else -> {
                return 6
            }
        }
    }

    //first column

    inner class ScrollImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val scroll_image_view_pager : ViewPager2 = itemView.findViewById(R.id.scroll_image_view_pager)
        val dot_indicator : SpringDotsIndicator = itemView.findViewById(R.id.dot_indicator)

    }

    //second column

    inner class TitleRatingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val product_title : TextView = itemView.findViewById(R.id.product_title)
        val rating_bar : RatingBar = itemView.findViewById(R.id.rating_bar)
        val product_no_review : TextView = itemView.findViewById(R.id.product_no_review)
        val product_available : TextView = itemView.findViewById(R.id.product_available)
    }

    //third column

    inner class DescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val item_description : TextView = itemView.findViewById(R.id.item_description)
    }

    //fourth column

    inner class ProductSpecificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val specification_recyclerview : RecyclerView = itemView.findViewById(R.id.specification_recyclerview)

    }

    //fifth column

    inner class RecommendedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val linearLayout : CardView = itemView.findViewById(R.id.recommended_parent_linear_layout)
        val recommended_recyclerview : RecyclerView = itemView.findViewById(R.id.recommended_recyclerview)
    }

    //sixth column

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val review_recyclerview : RecyclerView = itemView.findViewById(R.id.review_recyclerview)
    }

    //seventh column

    inner class RelatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val related_recyclerview : RecyclerView = itemView.findViewById(R.id.relate_recyclerview)
    }
}