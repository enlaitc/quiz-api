package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.QuizEntity

interface FindQuizDataProvider {
    fun findQuizById(id: Long):QuizEntity
}