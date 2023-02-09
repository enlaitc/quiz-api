package com.project.quizapi.domain.entity.vo

import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.QuestionTypeEnum

data class RequestSaveQuestionEntity(
    val idQuiz: Long,
    val question: String,
    val questionType: QuestionTypeEnum,
    val questionDifficult: DifficultCategoryEnum,
    val categories: List<Long>
)
