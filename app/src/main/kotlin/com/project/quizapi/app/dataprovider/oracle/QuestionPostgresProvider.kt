package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.QuestionRepository
import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.entity.QuestionEntity
import org.springframework.stereotype.Component

@Component
class QuestionPostgresProvider(private val questionRepository: QuestionRepository): QuestionDataProvider {
    override fun findQuestions(): MutableList<QuestionEntity> {
        val listQuestions = questionRepository.findAll().map { it -> it.toEntity() }

        return listQuestions.toMutableList()
    }
}