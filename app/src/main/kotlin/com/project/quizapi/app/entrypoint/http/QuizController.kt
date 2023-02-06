package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.QuizEntity
import com.project.quizapi.domain.usecase.QuizUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/quiz")
class QuizController(private val quizUseCase: QuizUseCase) {

    @GetMapping("/id/{idQuiz}")
    fun searchQuizById(@PathVariable idQuiz: Long): QuizEntity {
        return quizUseCase.findQuizById(idQuiz);
    }
}