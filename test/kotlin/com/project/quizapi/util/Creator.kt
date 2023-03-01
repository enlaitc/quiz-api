package com.project.quizapi.util

import com.project.quizapi.domain.entity.*
import com.project.quizapi.domain.entity.vo.ResponseCategoryEntity
import com.project.quizapi.domain.entity.vo.ResponseReviewEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Creator {

    fun questionEntityGenerico(): QuestionEntity {
        return QuestionEntity(
            1,
            quizEntityGenerico(),
            "question",
            QuestionTypeEnum.ALTERNATIVA,
            DifficultCategoryEnum.NORMAL,
            LocalDateTime.now(),
            null,
            listOf(categoryEntityGenerico()),
            null
        )
    }

    fun quizEntityGenerico(): QuizEntity {
        return QuizEntity(
            1,
            "quiz",
            LocalDate.now()
        )
    }

    fun categoryEntityGenerico(): CategoryEntity {
        return CategoryEntity(
            1,
            "categoria",
            null,
            null
        )
    }

    fun reviewEntityGenerico(): ReviewEntity{
        return ReviewEntity(
            1,
            quizEntityGenerico(),
            "user",
            0,
            DifficultCategoryEnum.NORMAL,
            LocalDateTime.now(),
            10L,
            LocalDateTime.now(),
            LocalDateTime.now(),
            listOf( categoryEntityGenerico() )
        )
    }

    fun responseReviewEntityGenerico(): ResponseReviewEntity{
        return ResponseReviewEntity(
            1,
            "quiz",
            "user",
            0,
            DifficultCategoryEnum.NORMAL,
            LocalTime.now(),
            10L,
            LocalDateTime.now(),
            LocalDateTime.now(),
            listOf( ResponseCategoryEntity(1,"categoria") )
        )
    }
}