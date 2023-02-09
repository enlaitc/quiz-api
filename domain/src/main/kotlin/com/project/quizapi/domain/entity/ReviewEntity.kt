package com.project.quizapi.domain.entity

import java.time.LocalDateTime

data class ReviewEntity(
    var idReview: Long?,
    var idQuiz: QuizEntity,
    var user: String,
    var score: Long,
    var difficult: DifficultCategoryEnum,
    var duration: LocalDateTime,
    var questions: Long,
    var start: LocalDateTime,
    var end: LocalDateTime?,

    var categories: List<CategoryEntity>?

)
