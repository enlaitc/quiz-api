package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.FindCategoryDataProvider
import com.project.quizapi.domain.dataprovider.FindQuizDataProvider
import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.QuizEntity
import com.project.quizapi.domain.entity.ReviewEntity
import org.springframework.stereotype.Service

@Service
class TesteUseCase(
    private val findCategoriesDataProvider: FindCategoryDataProvider,
    private val findQuizDataProvider: FindQuizDataProvider,
    private val questionDataProvider: QuestionDataProvider,
    private val reviewDataProvider: ReviewDataProvider
) {

    fun teste(): String {
        return "hello world"
    }

    fun findAllCategories(): MutableList<CategoryEntity> {
        return findCategoriesDataProvider.findCategories()
    }

    fun findQuizById(id: Long): QuizEntity {
        return findQuizDataProvider.findQuizById(id)
    }

    fun findAllQuestions(): MutableList<QuestionEntity> {
        return questionDataProvider.findQuestions()
    }

    fun findAllReviews(): MutableList<ReviewEntity> {
        return reviewDataProvider.findReviews()
    }
}