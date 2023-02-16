package com.project.quizapi.domain.entity.vo

import com.project.quizapi.domain.entity.DifficultCategoryEnum
import java.time.LocalDateTime
import java.time.LocalTime

data class ResponseReviewEntity(
    var idReview: Long,
    var quizName: String,
    var user: String,
    var score: Long,
    var difficult: DifficultCategoryEnum,
    var duration: LocalTime,
    var questions: Long,
    var start: LocalDateTime,
    var end: LocalDateTime,
    var categories: List<ResponseCategoryEntity>
)