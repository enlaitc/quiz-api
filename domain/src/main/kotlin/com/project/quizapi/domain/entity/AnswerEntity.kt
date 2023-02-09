package com.project.quizapi.domain.entity

data class AnswerEntity(
    var idAnswer: Long?,
    var idQuestion: Long,
    var answer: String,
    var status: Boolean
)
