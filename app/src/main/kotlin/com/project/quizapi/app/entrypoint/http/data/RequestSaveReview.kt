package com.project.quizapi.app.entrypoint.http.data

import com.project.quizapi.app.dataprovider.oracle.model.DifficultCategory

data class RequestSaveReview(
    val idQuiz: Long,
    val user: String,
    val difficult: DifficultCategory,
    val questions: Long,
)
