package com.project.quizapi.domain.entity

import java.time.LocalDateTime

data class QuestionEntity(
    var idQuestion: Long?,
    var idQuiz: QuizEntity,
    var question: String,
    var questionType: QuestionTypeEnum,
    var questionDifficult: DifficultCategoryEnum,
    var creation: LocalDateTime,
    var update: LocalDateTime?,

    var categories: List<CategoryEntity>?,

    var answers: List<AnswerEntity>?

    )
