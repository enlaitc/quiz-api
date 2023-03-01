package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import com.project.quizapi.domain.dataprovider.QuizDataProvider
import com.project.quizapi.domain.entity.QuizEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class QuizPostgresProvider(private val quizRepository: QuizRepository) : QuizDataProvider {
    override fun findQuizById(id: Long): QuizEntity {
        val quiz = quizRepository.findById(id)
        if(quiz.isEmpty) throw EntityNotFoundException("Quiz not found")
        return quiz.get().toEntity()
    }
}