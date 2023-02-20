package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.model.toReview
import com.project.quizapi.app.dataprovider.oracle.repository.ReviewRepository
import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.ReviewEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class ReviewPostgresProvider(private val repository: ReviewRepository) : ReviewDataProvider {
    override fun findReviewById(idReview: Long): ReviewEntity {
        val review = repository.findById(idReview)
        if(review.isEmpty) throw EntityNotFoundException("Review not found")
        return review.get().toEntity()
    }

    override fun saveReview(reviewEntity: ReviewEntity): ReviewEntity {
        return repository.save(reviewEntity.toReview()).toEntity()
    }
}