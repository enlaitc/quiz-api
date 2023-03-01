package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toCategory
import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.model.toQuestion
import com.project.quizapi.app.dataprovider.oracle.repository.QuestionRepository
import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class QuestionPostgresProvider(private val repository: QuestionRepository) : QuestionDataProvider {
    override fun findQuestions(): MutableList<QuestionEntity> {
        val listQuestions = repository.findAll().map { it -> it.toEntity() }
        return listQuestions.toMutableList()
    }

    override fun findQuestionsByCategories(categories: List<CategoryEntity>): MutableList<QuestionEntity> {
        val listCategories = categories.map { it.toCategory() }

        val listQuestions = listCategories.map { category ->
            repository.findByCategories(category) }[0].map { question ->
            question.toEntity()
        }

        return listQuestions.toMutableList()
    }

    override fun findQuestionById(questionId: Long): QuestionEntity {
        val question = repository.findById(questionId)
        if (question.isEmpty) throw EntityNotFoundException("Question not found")
        return question.get().toEntity()
    }

    override fun saveQuestion(questionEntity: QuestionEntity): QuestionEntity {
        return repository.save(questionEntity.toQuestion()).toEntity()
    }
}