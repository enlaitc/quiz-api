package com.project.quizapi.domain.entity

data class AnswerEntity(
    var idAnswer: Long?,
    var question: Long,
    var answer: String,
    var status: Boolean
)
