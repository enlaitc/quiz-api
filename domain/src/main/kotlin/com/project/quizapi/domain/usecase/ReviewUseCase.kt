package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import org.springframework.stereotype.Service
import java.time.Duration
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

    fun startQuizSaveReview(requestSaveReview: RequestSaveReviewEntity): ReviewEntity {
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
            categories = requestSaveReview.categories.map { it -> categoryUseCase.findCategoryById(it) }
        )

        return reviewDataProvider.saveReview(entity)
    }

    fun endQuizUpdateReview(requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity {
        val review = findReviewById(requestUpdateReview.idReview)

        val calcDuration = review.duration.minus(Duration.between(review.duration, LocalTime.now()))

        val entity = ReviewEntity(
            idReview = review.idReview,
            idQuiz = review.idQuiz,
            user = review.user,
            score = requestUpdateReview.score,
            difficult = review.difficult,
            duration = calcDuration,
            questions = review.questions,
            start = review.start,
            end = LocalDateTime.now(),
            categories = review.categories
        )

        return reviewDataProvider.saveReview(entity)
    }

}