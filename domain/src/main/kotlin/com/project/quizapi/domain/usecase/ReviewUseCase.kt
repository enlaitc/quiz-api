package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.LocalTime

@Service
class ReviewUseCase(
    private val reviewDataProvider: ReviewDataProvider,
    private val quizUseCase: QuizUseCase,
    private val categoryUseCase: CategoryUseCase
) {

    fun findReviewById(idReview: Long): ReviewEntity {
        return reviewDataProvider.findReviewById(idReview)
    }

    fun saveReview(requestSaveReview: RequestSaveReviewEntity): ReviewEntity {
        val entity = ReviewEntity(
            idReview = null,
            idQuiz = quizUseCase.findQuizById(1),
            user = requestSaveReview.user,
            score = 0,
            difficult = requestSaveReview.difficult,
            duration = LocalTime.now(),
            questions = requestSaveReview.questions,
            start = LocalDateTime.now(),
            end = null,
            categories = requestSaveReview.categories?.map { it -> categoryUseCase.findCategoryById(it) }
        )

        return reviewDataProvider.saveReview(entity)
    }

}