package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.vo.SaveAnswerEntity

interface AnswerDataProvider {
    fun saveAnswer(saveAnswerEntity: SaveAnswerEntity): AnswerEntity
}