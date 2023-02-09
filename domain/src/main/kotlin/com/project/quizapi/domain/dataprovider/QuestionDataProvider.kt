package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity

interface QuestionDataProvider {
    fun findQuestions(): MutableList<QuestionEntity>
    fun findQuestionsByCategories(categories: List<CategoryEntity>): MutableList<QuestionEntity>
    fun findQuestionById(questionId: Long): QuestionEntity
    fun saveQuestion(questionEntity: QuestionEntity): QuestionEntity
}