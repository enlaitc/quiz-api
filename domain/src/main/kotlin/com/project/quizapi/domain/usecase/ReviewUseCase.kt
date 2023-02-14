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
            duration = LocalDateTime.now(),
            questions = requestSaveReview.questions,
            start = LocalDateTime.now(),
            end = null,
            categories = requestSaveReview.categoriesId.map { it -> categoryUseCase.findCategoryById(it) }
        )

        return reviewDataProvider.saveReview(entity)
    }

    fun endQuizUpdateReview(requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity {
        val review = findReviewById(requestUpdateReview.idReview)

        val entity = ReviewEntity(
            idReview = review.idReview,
            idQuiz = review.idQuiz,
            user = review.user,
            score = requestUpdateReview.score,
            difficult = review.difficult,
            duration = calculaDuration(review.duration),
            questions = review.questions,
            start = review.start,
            end = LocalDateTime.now(),
            categories = review.categories
        )

        return reviewDataProvider.saveReview(entity)
    }

    private fun calculaDuration(reviewDuration: LocalDateTime): LocalDateTime {
        val durationBetween = Duration.between(reviewDuration, LocalDateTime.now())
        val localTimeDuration = LocalTime.of(
            durationBetween.toHoursPart(),
            durationBetween.toMinutesPart(),
            durationBetween.toSecondsPart()
        )

        return LocalDateTime.of(reviewDuration.toLocalDate(), localTimeDuration)
    }

}