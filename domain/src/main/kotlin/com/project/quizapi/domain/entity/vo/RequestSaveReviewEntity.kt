package com.project.quizapi.domain.entity.vo

import com.project.quizapi.domain.entity.DifficultCategoryEnum

data class RequestSaveReviewEntity(
    val user: String,
    val difficult: DifficultCategoryEnum,
    val questions: Long,
    val categoriesId: List<Long>
)
