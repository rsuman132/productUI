package com.example.productui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.productui.adapter.ParentAdapter
import com.example.productui.model.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val item = ArrayList<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.main_RecyclerView)
        val parentAdapter = ParentAdapter(this, getData())
        recyclerView.adapter = parentAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun getData(): ArrayList<Any>{
        item.add(getScrollImage()[0])
        item.add(getTitleRating()[0])
        item.add(getDescription()[0])
        item.add(getProductSpecification()[0])
        item.add(getRecommendedProduct()[0])
        item.add(getReviewedItems()[0])
        item.add(getRelatedProduct()[0])
        return item
    }

    companion object {

        //R.drawable.wheels1
        fun getScrollImage(): ArrayList<ImageList>{
            val imageList = ArrayList<ImageList>()
            imageList.add(ImageList(R.drawable.wheels1))
            imageList.add(ImageList(R.drawable.wheels2))
            imageList.add(ImageList(R.drawable.wheels3))
            imageList.add(ImageList(R.drawable.wheels4))
            imageList.add(ImageList(R.drawable.wheels5))

            return imageList
        }

        fun getTitleRating(): ArrayList<TitleRating>{
            val titleRating = ArrayList<TitleRating>()
            titleRating.add(TitleRating("Terra Former Tractor Light Performer Dirt",  "2 Reviews", "15 Available"))

            return titleRating

        }

        fun getDescription() : ArrayList<Description>{
            val description = ArrayList<Description>()
            description.add(Description("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\'t anything embarrassing hidden in the middle of text."))

            return description
        }

        fun getProductSpecification() : ArrayList<ProductSpecs>{
            val productSpecs = ArrayList<ProductSpecs>()
            productSpecs.add(ProductSpecs("Type", "Winter"))
            productSpecs.add(ProductSpecs("Brand", "Avon"))
            productSpecs.add(ProductSpecs("Model", "230i"))
            productSpecs.add(ProductSpecs("Year from", "2016"))
            productSpecs.add(ProductSpecs("Pitch Center Diameter", "Bolt Pattern"))

            return productSpecs
        }

        //R.drawable.wheels1
        fun getRecommendedProduct(): ArrayList<RecommendProduct>{
            val recommendProduct = ArrayList<RecommendProduct>()
            recommendProduct.add(RecommendProduct(R.drawable.wheels1, "MRF Tyres", "₹ 2,545"))
            recommendProduct.add(RecommendProduct(R.drawable.wheels2,  "Apollo", "₹ 2,678"))
            recommendProduct.add(RecommendProduct(R.drawable.wheels3,  "Michelin", "₹ 3,000"))
            recommendProduct.add(RecommendProduct(R.drawable.wheels4,  "CEAT", "₹ 2,500"))
            recommendProduct.add(RecommendProduct(R.drawable.wheels5,  "Bridgestone", "₹ 2,800"))

            return recommendProduct
        }

        //R.drawable.user1
        fun getReviewedItems(): ArrayList<ProductReview>{
            val productReview = ArrayList<ProductReview>()
            productReview.add(ProductReview(R.drawable.user1, "Keanu Reeves", 4.0f, "6 August, 2020","If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet."))
            productReview.add(ProductReview(R.drawable.user2, "Robert Downey Jr", 4.0f, "7 December, 2020", "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet."))
            productReview.add(ProductReview(R.drawable.user3, "Christian Bale", 4.0f, "27 June, 2020", "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet."))
            productReview.add(ProductReview(R.drawable.user4, "Ryan Reynolds", 3.0f, "23 October, 2020",  "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."))

            return productReview
        }

        //R.drawable.related1
        fun getRelatedProduct() : ArrayList<RelatedProduct>{
            val relatedProduct = ArrayList<RelatedProduct>()
            relatedProduct.add(RelatedProduct(R.drawable.related1, "Castrol Engine oil", "₹ 700"))
            relatedProduct.add(RelatedProduct(R.drawable.related2, "Car Side Door", "₹ 2,789"))
            relatedProduct.add(RelatedProduct(R.drawable.related3, "Mirror", "₹ 300"))
            relatedProduct.add(RelatedProduct(R.drawable.related4, "Tata Accelerator", "₹ 1,000"))
            relatedProduct.add(RelatedProduct(R.drawable.related5, "Toyato Gear", "₹ 2,345"))
            relatedProduct.add(RelatedProduct(R.drawable.related1, "Castrol Engine oil", "₹ 700"))
            relatedProduct.add(RelatedProduct(R.drawable.related2, "Car Side Door", "₹ 2,789"))
            relatedProduct.add(RelatedProduct(R.drawable.related3, "Mirror", "₹ 300"))
            relatedProduct.add(RelatedProduct(R.drawable.related4, "Tata Accelerator", "₹ 1,000"))
            relatedProduct.add(RelatedProduct(R.drawable.related5, "Toyato Gear", "₹ 2,345"))
            relatedProduct.add(RelatedProduct(R.drawable.related1, "Castrol Engine oil", "₹ 700"))
            relatedProduct.add(RelatedProduct(R.drawable.related2, "Car Side Door", "₹ 2,789"))
            relatedProduct.add(RelatedProduct(R.drawable.related3, "Mirror", "₹ 300"))
            relatedProduct.add(RelatedProduct(R.drawable.related4, "Tata Accelerator", "₹ 1,000"))
            relatedProduct.add(RelatedProduct(R.drawable.related5, "Toyato Gear", "₹ 2,345"))


            return relatedProduct

        }

    }

}