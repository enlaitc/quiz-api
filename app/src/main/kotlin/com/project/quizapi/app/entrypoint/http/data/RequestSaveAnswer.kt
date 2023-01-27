package com.project.quizapi.app.entrypoint.http.data

data class RequestSaveAnswer(
    val questionId: Long,
    val answer: String,
    val status: Boolean
)
