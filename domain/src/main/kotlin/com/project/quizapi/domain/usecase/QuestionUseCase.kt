package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.entity.QuestionEntity
import org.springframework.stereotype.Service

@Service
class QuestionUseCase(
    private val questionDataProvider: QuestionDataProvider,
    private val categoryUseCase: CategoryUseCase
) {

    fun findQuestionByCategories(categoriesId: List<Long>): MutableList<QuestionEntity>{
        val listCategories = categoriesId.map { categoryUseCase.findCategoryById(it) }

        return questionDataProvider.findQuestionsByCategories(listCategories)
    }
}