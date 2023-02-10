package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toAnswer
import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.AnswerRepository
import com.project.quizapi.domain.dataprovider.AnswerDataProvider
import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.vo.SaveAnswerEntity
import org.springframework.stereotype.Component

@Component
class AnswerPostgresProvider(private val repository: AnswerRepository): AnswerDataProvider {
    override fun saveAnswer(saveAnswerEntity: SaveAnswerEntity): AnswerEntity {
        return repository.save(saveAnswerEntity.toAnswer()).toEntity()
    }

}