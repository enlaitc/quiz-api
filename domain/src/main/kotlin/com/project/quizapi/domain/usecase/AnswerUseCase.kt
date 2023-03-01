package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.AnswerDataProvider
import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.vo.SaveAnswerEntity
import org.springframework.stereotype.Service

@Service
class AnswerUseCase(
    private val answerDataProvider: AnswerDataProvider,
    private val questionUseCase: QuestionUseCase) {

    fun saveAnswer(answerEntity: AnswerEntity): AnswerEntity {

        val answer =  SaveAnswerEntity(
            idAnswer = null,
            question = questionUseCase.findQuestionById(answerEntity.idQuestion),
            answer = answerEntity.answer,
            status = answerEntity.status
        )

        return answerDataProvider.saveAnswer(answer)
    }
}