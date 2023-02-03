package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.ReviewEntity

interface ReviewDataProvider {
    fun findReviews(): MutableList<ReviewEntity>
    fun findReviewById(idReview: Long): ReviewEntity
    fun saveReview(reviewEntity: ReviewEntity): ReviewEntity
}