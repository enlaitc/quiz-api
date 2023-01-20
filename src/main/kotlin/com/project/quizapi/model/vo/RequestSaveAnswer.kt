package com.project.quizapi.model.vo

data class RequestSaveAnswer(
    val questionId: Long,
    val answer: String,
    val status: Boolean
)
