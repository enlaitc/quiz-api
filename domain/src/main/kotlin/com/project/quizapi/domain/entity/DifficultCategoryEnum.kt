package com.project.quizapi.domain.entity

enum class DifficultCategoryEnum(val percentNormal: Long, val percentDificil: Long) {

    NORMAL(70,30),
    DIFICIL(50,50)
}