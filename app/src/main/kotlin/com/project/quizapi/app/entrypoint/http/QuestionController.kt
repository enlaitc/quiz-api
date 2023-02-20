package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.vo.RequestSaveQuestionEntity
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.usecase.QuestionUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Question")
@RestController
@RequestMapping("question/api")
class QuestionController(val questionUseCase: QuestionUseCase) {

    @Operation(summary = "Save Question.")
    @PostMapping
    fun saveQuestion(@RequestBody question: RequestSaveQuestionEntity): QuestionEntity {
        return questionUseCase.saveQuestion(question)
    }

    @Operation(summary = "Find Question by ID.")
    @GetMapping("/id/{questionId}")
    fun getQuestion(@PathVariable questionId: Long): QuestionEntity {
        return questionUseCase.findQuestionById(questionId)
    }

    @Operation(summary = "Find Questions by category.")
    @GetMapping("/categoriesId/{categoriesId}")
    fun findQuestionsByCategory(@PathVariable categoriesId: List<Long>): List<QuestionEntity>{
        return questionUseCase.findQuestionByCategories(categoriesId)
    }
}