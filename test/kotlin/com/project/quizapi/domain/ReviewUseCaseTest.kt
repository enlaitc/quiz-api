package com.project.quizapi.domain

import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.usecase.CategoryUseCase
import com.project.quizapi.domain.usecase.QuizUseCase
import com.project.quizapi.domain.usecase.ReviewUseCase
import com.project.quizapi.util.Creator
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDateTime
import java.util.*

@ExtendWith(MockKExtension::class)
class ReviewUseCaseTest {

    @MockK
    lateinit var quizUseCase: QuizUseCase

    @MockK
    lateinit var categoryUseCase: CategoryUseCase

    @MockK
    lateinit var reviewDataProvider: ReviewDataProvider

    @InjectMockKs
    lateinit var reviewUseCase: ReviewUseCase

    private val creator = Creator()

    @Test
    @DisplayName("Start quiz save review salva e retorna uma ReviewEntity se sucesso")
    fun startQuizSaveReview_Success() {
        val requestSaveReview = RequestSaveReviewEntity(
            "user",
            DifficultCategoryEnum.NORMAL,
            10L,
            listOf(1)
        )
        val listCategory = listOf(creator.categoryEntityGenerico())
        val quizEntity = creator.quizEntityGenerico()
        val entityReturn = ReviewEntity(
            1,
            quizEntity,
            requestSaveReview.user,
            0,
            requestSaveReview.difficult,
            LocalDateTime.now(),
            requestSaveReview.qtQuestions,
            LocalDateTime.now(),
            null,
            listCategory
        )

        every { quizUseCase.findQuizById(any()) } returns quizEntity
        every { categoryUseCase.findCategoryById(any()) } returns listCategory[0]
        every { reviewDataProvider.saveReview(ofType(ReviewEntity::class)) } returns entityReturn

        val result = reviewUseCase.startQuizSaveReview(requestSaveReview)

        Assertions.assertEquals(entityReturn, result)
        verify(exactly = 1) { quizUseCase.findQuizById(any()) }
        verify(exactly = 1) { categoryUseCase.findCategoryById(listCategory[0].idCategory!!) }
        verify(exactly = 1) { reviewDataProvider.saveReview(ofType(ReviewEntity::class)) }
    }

    @Test
    @DisplayName("End Quiz Update Review atualiza e retorna Review Entity se sucesso")
    fun endQuizUpdateReview_Success() {
        val requestUpdateReview = RequestUpdateReviewEntity(
            1,
            10
        )
        val review = creator.reviewEntityGenerico()
        val entityReturn = ReviewEntity(
            1,
            creator.quizEntityGenerico(),
            review.user,
            requestUpdateReview.score,
            review.difficult,
            LocalDateTime.now(),
            review.questions,
            review.start,
            LocalDateTime.now(),
            review.categories
        )

        every { reviewUseCase.findReviewById(requestUpdateReview.idReview) } returns review
        every { reviewDataProvider.saveReview(ofType(ReviewEntity::class)) } returns entityReturn

        val result = reviewUseCase.endQuizUpdateReview(requestUpdateReview)

        Assertions.assertEquals(entityReturn, result)
        verify(exactly = 1) { reviewUseCase.findReviewById(requestUpdateReview.idReview) }
        verify(exactly = 1) { reviewDataProvider.saveReview(ofType(ReviewEntity::class)) }
    }

    @Test
    @DisplayName("Find Review By Id retorna Review Entity passando um id se sucesso")
    fun findReviewById_Success() {
        val idReview = 1L
        val reviewReturn = creator.reviewEntityGenerico()

        every { reviewUseCase.findReviewById(idReview) } returns reviewReturn

        val result = reviewUseCase.findReviewById(idReview)

        Assertions.assertEquals(reviewReturn, result)
        verify(exactly = 1) { reviewUseCase.findReviewById(idReview) }
    }

}