package com.project.quizapi.app.entrypoint.http.data

import com.project.quizapi.app.dataprovider.oracle.model.Category
import com.project.quizapi.domain.entity.DifficultCategoryEnum

data class RequestSaveReview(
    val idQuiz: Long,
    val user: String,
    val difficult: DifficultCategoryEnum,
    val questions: Long,
    val categories: List<Category>
)
