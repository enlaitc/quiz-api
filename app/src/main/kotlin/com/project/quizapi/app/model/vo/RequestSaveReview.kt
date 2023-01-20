package com.project.quizapi.app.model.vo

import com.project.quizapi.app.model.enums.DifficultCategory

data class RequestSaveReview(
    val idQuiz: Long,
    val user: String,
    val difficult: DifficultCategory,
    val questions: Long,
)
