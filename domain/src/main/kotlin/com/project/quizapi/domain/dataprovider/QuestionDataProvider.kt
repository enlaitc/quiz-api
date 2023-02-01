package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.QuestionEntity

interface QuestionDataProvider {
    fun findQuestions(): MutableList<QuestionEntity>
}