package com.project.quizapi.model

import com.project.quizapi.model.enums.QuestionType
import java.time.LocalDateTime

data class Question(
    var idQuestions: Long,
    var quiz: Quiz,
    var question: String,
    var questionType: QuestionType,
    var category: Category,
    var creation: LocalDateTime,
    var update: LocalDateTime

    )
