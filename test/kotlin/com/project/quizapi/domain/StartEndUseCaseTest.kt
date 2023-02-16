package com.project.quizapi.domain

import com.project.quizapi.domain.entity.*
import com.project.quizapi.domain.entity.vo.*
import com.project.quizapi.domain.usecase.QuestionUseCase
import com.project.quizapi.domain.usecase.ReviewUseCase
import com.project.quizapi.domain.usecase.StartEndUseCase
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

@ExtendWith(MockKExtension::class)
class StartEndUseCaseTest {

    @MockK(relaxed = true)
    lateinit var reviewUseCase: ReviewUseCase

    @MockK(relaxed = true)
    lateinit var questionUseCase: QuestionUseCase

    @InjectMockKs
    lateinit var useCase: StartEndUseCase

    private val creator = Creator()


    @Test
    @DisplayName("Start Quiz retorna mutable list de responseQuestion se sucesso")
    fun startQuiz() {
        val requestSaveReview = RequestSaveReviewEntity(
            "user",
            DifficultCategoryEnum.NORMAL,
            10L,
            listOf(1)
        )
        val idReview = 1L
        val questions = mutableListOf(creator.questionEntityGenerico())
        val responseQuestion = mutableListOf(
            ResponseQuestionEntity(
                1,
                "question",
                QuestionTypeEnum.ALTERNATIVA,
                requestSaveReview.difficult,
                listOf(
                    ResponseCategoryEntity(
                        1,
                        "categoria"
                    )
                ),
                null
            )
        )

        every { reviewUseCase.startQuizSaveReview(requestSaveReview).idReview } returns idReview
        every { questionUseCase.findQuestionByCategories(any()) } returns questions

        val result = useCase.startQuiz(requestSaveReview)

        Assertions.assertEquals(responseQuestion, result)
        verify(exactly = 1) { reviewUseCase.startQuizSaveReview(requestSaveReview) }
        verify(exactly = 1) { questionUseCase.findQuestionByCategories(requestSaveReview.categoriesId) }
    }

    @Test
    @DisplayName("End Quiz retorna ReviewEntity se sucesso")
    fun endQuiz() {
        val requestUpdateReview = RequestUpdateReviewEntity(
            1,
            10
        )
        val review = creator.reviewEntityGenerico()
        review.score = requestUpdateReview.score

        val responseReviewReturn = creator.responseReviewEntityGenerico()
        responseReviewReturn.score = requestUpdateReview.score
        responseReviewReturn.duration = review.duration.toLocalTime()
        responseReviewReturn.start = review.start
        responseReviewReturn.end = review.end!!

        every { reviewUseCase.endQuizUpdateReview(requestUpdateReview) } returns review

        val result = useCase.endQuiz(requestUpdateReview)

        Assertions.assertEquals(result, responseReviewReturn)
        verify(exactly = 1) { reviewUseCase.endQuizUpdateReview(requestUpdateReview) }
    }
}