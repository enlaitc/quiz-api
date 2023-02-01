package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.QuizEntity
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.usecase.TesteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class TesteController(val testeUseCase: TesteUseCase) {

    @GetMapping("/teste/{param}")
    fun nomeDoFan(@PathVariable param: String): String {
        return "Você digitou $param"
    }

    @GetMapping("/usecase")
    fun teste(): String {
        return testeUseCase.teste()
    }

    @GetMapping("/category")
    fun buscaTodasCategorias(): MutableList<CategoryEntity> {
        return testeUseCase.findAllCategories()
    }

    @GetMapping("/id/{idQuiz}")
    fun buscaQuizPorId(@PathVariable idQuiz: Long): QuizEntity {
        return testeUseCase.findQuizById(idQuiz)
    }

    @GetMapping("/question")
    fun buscaTodasQuestoes(): MutableList<QuestionEntity> {
        return testeUseCase.findAllQuestions()
    }

    @GetMapping("/reviews")
    fun buscaTodasReviews(): MutableList<ReviewEntity> {
        return testeUseCase.findAllReviews()
    }
}