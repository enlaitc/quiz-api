package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.QuizEntity

interface QuizDataProvider {
    fun findQuizById(id: Long):QuizEntity
}