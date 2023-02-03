package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.QuizDataProvider
import com.project.quizapi.domain.entity.QuizEntity
import org.springframework.stereotype.Service

@Service
class QuizUseCase(
    private val quizDataProvider: QuizDataProvider
) {

    fun findQuizById(quizId: Long): QuizEntity {
        return quizDataProvider.findQuizById(quizId)
    }
}