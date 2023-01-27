package com.project.quizapi.domain.entity

import java.time.LocalDate

data class QuizEntity(

    var idQuiz: Long?,
    var name: String,
    var creation: LocalDate,

    )