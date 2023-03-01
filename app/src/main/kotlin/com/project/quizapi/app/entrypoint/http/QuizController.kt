package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.QuizEntity
import com.project.quizapi.domain.usecase.QuizUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "Quiz")
@RestController
@RequestMapping("quiz/api")
class QuizController(private val quizUseCase: QuizUseCase) {

    @Operation(summary = "Find Quiz by ID.")
    @GetMapping("/id/{idQuiz}")
    fun findQuizById(@PathVariable idQuiz: Long): QuizEntity {
        return quizUseCase.findQuizById(idQuiz);
    }
}