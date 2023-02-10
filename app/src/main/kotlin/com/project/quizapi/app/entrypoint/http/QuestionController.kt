package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.vo.RequestSaveQuestionEntity
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.usecase.QuestionUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionController(val questionUseCase: QuestionUseCase) {

    @PostMapping
    fun saveQuestion(@RequestBody question: RequestSaveQuestionEntity): QuestionEntity {
        return questionUseCase.saveQuestion(question)
    }

    @GetMapping("/id/{questionId}")
    fun getQuestion(@PathVariable questionId: Long): QuestionEntity {
        return questionUseCase.findQuestionById(questionId)
    }

    @GetMapping("/categoriesId/{categoriesId}")
    fun buscaQuestoesPorCategorias(@PathVariable categoriesId: List<Long>): MutableList<QuestionEntity>{
        return questionUseCase.findQuestionByCategories(categoriesId)
    }
}