package com.project.quizapi.model.vo

import com.project.quizapi.model.Category
import com.project.quizapi.model.enums.DifficultCategory
import com.project.quizapi.model.enums.QuestionType

data class RequestSaveQuestion(
    val idQuiz: Long,
    val question: String,
    val questionType: QuestionType,
    val questionDifficult: DifficultCategory,
    val categories: List<Category>
)
