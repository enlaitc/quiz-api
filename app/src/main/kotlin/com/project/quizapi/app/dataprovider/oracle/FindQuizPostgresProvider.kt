package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import com.project.quizapi.domain.dataprovider.FindQuizDataProvider
import com.project.quizapi.domain.entity.QuizEntity
import org.springframework.stereotype.Component

@Component
class FindQuizPostgresProvider(private val quizRepository: QuizRepository) : FindQuizDataProvider {
    override fun findQuizById(id: Long): QuizEntity {
        return quizRepository.findById(id).get().toEntity()
    }
}