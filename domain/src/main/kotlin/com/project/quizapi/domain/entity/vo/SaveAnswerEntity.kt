package com.project.quizapi.domain.entity.vo

import com.project.quizapi.domain.entity.QuestionEntity

data class SaveAnswerEntity(
    var idAnswer: Long?,
    var question: QuestionEntity,
    var answer: String,
    var status: Boolean
)
