package com.project.quizapi.model

data class Answer(
    var idAnswer: Long,
    var question: Question,
    var answer: String,
    var status: Boolean
)
