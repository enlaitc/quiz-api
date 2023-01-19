package com.project.quizapi.model.vo

import com.project.quizapi.model.enums.DifficultCategory

data class RequestSaveReview(
    val idQuiz: Long,
    val user: String,
    val difficult: DifficultCategory,
    val questions: Long,
)
