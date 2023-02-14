package com.project.quizapi.domain

import com.project.quizapi.domain.entity.*
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.entity.vo.ResponseQuestion
import com.project.quizapi.domain.usecase.QuestionUseCase
import com.project.quizapi.domain.usecase.ReviewUseCase
import com.project.quizapi.domain.usecase.StartEndUseCase
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate
import java.time.LocalDateTime

@ExtendWith(MockKExtension::class)
class StartEndUseCaseTest {

    @MockK(relaxed = true)
    lateinit var reviewUseCase: ReviewUseCase

    @MockK(relaxed = true)
    lateinit var questionUseCase: QuestionUseCase

    @InjectMockKs
    lateinit var useCase: StartEndUseCase


    @Test
    @DisplayName("Start Quiz retorna mutable list de responseQuestion se sucesso")
    fun startQuiz() {
        val requestsaveReview = RequestSaveReviewEntity(
            "user",
            DifficultCategoryEnum.NORMAL,
            10L,
            listOf(1)
        )

        val idreview = 1L

        val questions = mutableListOf(
            QuestionEntity(
                1,
                QuizEntity(
                    1,
                    "quiz",
                    LocalDate.now()
                ),
                "question",
                QuestionTypeEnum.ALTERNATIVA,
                requestsaveReview.difficult,
                LocalDateTime.now(),
                null,
                null,
                null
            )
        )

        val responseQuestion = mutableListOf(
            ResponseQuestion(
                1,
                "question",
                QuestionTypeEnum.ALTERNATIVA,
                requestsaveReview.difficult,
                null,
                null
            )
        )

        every { reviewUseCase.startQuizSaveReview(requestsaveReview).idReview } returns idreview
        every { questionUseCase.findQuestionByCategories(any()) } returns questions

        val result = useCase.startQuiz(requestsaveReview)

        Assertions.assertEquals(responseQuestion, result)
        verify(exactly = 1) { reviewUseCase.startQuizSaveReview(requestsaveReview) }
        verify(exactly = 1) { questionUseCase.findQuestionByCategories(requestsaveReview.categoriesId) }
    }

    @Test
    @DisplayName("End Quiz retorna ReviewEntity se sucesso")
    fun endQuiz() {
        val requestUpdateReview = RequestUpdateReviewEntity(
            1,
            10
        )

        val reviewEntity = ReviewEntity(
            requestUpdateReview.idReview,
            QuizEntity(
                1,
                "quiz",
                LocalDate.now()
            ),
            "user",
            requestUpdateReview.score,
            DifficultCategoryEnum.NORMAL,
            LocalDateTime.now(),
            10,
            LocalDateTime.now(),
            null,
            null
        )

        every { reviewUseCase.endQuizUpdateReview(requestUpdateReview) } returns reviewEntity

        val result = useCase.endQuiz(requestUpdateReview)

        Assertions.assertEquals(result,reviewEntity)
        verify(exactly = 1) { reviewUseCase.endQuizUpdateReview(requestUpdateReview) }
    }
}