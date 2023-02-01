package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.ReviewRepository
import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.ReviewEntity
import org.springframework.stereotype.Component

@Component
class ReviewPostgresProvider(private val repository: ReviewRepository): ReviewDataProvider {
    override fun findReviews(): MutableList<ReviewEntity> {
        val reviewList = repository.findAll().map { it -> it.toEntity() }

        return reviewList.toMutableList()
    }
}