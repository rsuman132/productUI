package com.example.productui.model

data class ProductReview(
        var reviewerImage : Int,
        var reviewerName : String,
        var reviewerRating : Float,
        var reviewed_date : String,
        var review_content : String
)