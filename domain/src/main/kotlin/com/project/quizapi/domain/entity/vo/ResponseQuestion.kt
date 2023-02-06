package com.project.quizapi.domain.entity.vo

import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.QuestionTypeEnum

data class ResponseQuestion(
    val idReview: Long,
    val question: String,
    val questionType: QuestionTypeEnum,
    val questionDifficult: DifficultCategoryEnum,
    val categories: List<CategoryEntity>?,
    val answers: List<AnswerEntity>?
)
