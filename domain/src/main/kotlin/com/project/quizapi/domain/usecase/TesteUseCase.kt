package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.CategoryDataProvider
import com.project.quizapi.domain.dataprovider.QuizDataProvider
import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.dataprovider.ReviewDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.QuizEntity
import com.project.quizapi.domain.entity.ReviewEntity
import org.springframework.stereotype.Service

@Service
class TesteUseCase(
    private val findCategoriesDataProvider: CategoryDataProvider,
    private val quizDataProvider: QuizDataProvider,
    private val questionDataProvider: QuestionDataProvider,
    private val reviewDataProvider: ReviewDataProvider
) {

    fun findAllCategories(): MutableList<CategoryEntity> {
        return findCategoriesDataProvider.findCategories()
    }

    fun findQuizById(id: Long): QuizEntity {
        return quizDataProvider.findQuizById(id)
    }

    fun findAllQuestions(): MutableList<QuestionEntity> {
        return questionDataProvider.findQuestions()
    }

    fun findAllReviews(): MutableList<ReviewEntity> {
        return reviewDataProvider.findReviews()
    }
}