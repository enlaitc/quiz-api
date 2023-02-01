package com.project.quizapi.domain.entity

data class CategoryEntity(
    var idCategory: Long,
    var name: String,
    var questions: List<QuestionEntity>?
)
