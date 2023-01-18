package com.project.quizapi.model

import com.project.quizapi.model.enums.DifficultCategory
import java.time.LocalDateTime
import java.time.LocalTime

data class Review(
    var idReview: Long,
    var quiz: Quiz,
    var user: String,
    var score: Long,
    var difficult: DifficultCategory,
    var duration: LocalTime,
    var questions: Long,
    var start: LocalDateTime,
    var end: LocalDateTime

)
