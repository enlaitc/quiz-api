package com.project.quizapi.domain.entity

import java.time.LocalDateTime
import java.time.LocalTime

data class ReviewEntity(
    var idReview: Long?,
    var idQuiz: QuizEntity,
    var user: String,
    var score: Long,
    var difficult: DifficultCategoryEnum,
    var duration: LocalTime,
    var questions: Long,
    var start: LocalDateTime,
    var end: LocalDateTime?,

    var categories: List<CategoryEntity>?

)
