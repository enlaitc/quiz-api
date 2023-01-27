package com.project.quizapi.app.model.vo

data class RequestSaveAnswer(
    val questionId: Long,
    val answer: String,
    val status: Boolean
)
