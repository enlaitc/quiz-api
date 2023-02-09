package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.Question
import com.project.quizapi.app.dataprovider.oracle.model.toCategory
import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.model.toQuestion
import com.project.quizapi.app.dataprovider.oracle.repository.QuestionRepository
import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity
import org.springframework.stereotype.Component

@Component
class QuestionPostgresProvider(private val repository: QuestionRepository) : QuestionDataProvider {
    override fun findQuestions(): MutableList<QuestionEntity> {
        val listQuestions = repository.findAll().map { it -> it.toEntity() }

        return listQuestions.toMutableList()
    }

    override fun findQuestionsByCategories(categories: List<CategoryEntity>): MutableList<QuestionEntity> {
        val listCategories = categories.map { it.toCategory() }

        val listQuestions = mutableListOf<Question>()
        listCategories.forEach { category -> repository.findByCategories(category).forEach { listQuestions.add(it) } }

        return listQuestions.map { it.toEntity() }
            .distinctBy { it.idQuestion }
            .toMutableList()
    }

    override fun findQuestionById(questionId: Long): QuestionEntity {
        return repository.findById(questionId).get().toEntity()
    }

    override fun saveQuestion(questionEntity: QuestionEntity): QuestionEntity {
        return repository.save(questionEntity.toQuestion()).toEntity()
    }
}