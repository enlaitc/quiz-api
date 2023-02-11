package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.app.dataprovider.oracle.model.Answer
import com.project.quizapi.app.entrypoint.http.data.RequestSaveAnswer
import com.project.quizapi.app.dataprovider.oracle.repository.AnswerRepository
import com.project.quizapi.app.dataprovider.oracle.repository.QuestionRepository
import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.vo.SaveAnswerEntity
import com.project.quizapi.domain.usecase.AnswerUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Answer")
@RestController
@RequestMapping("answer/api")
class AnswerController (val answerUseCase: AnswerUseCase){

    @Operation(summary = "Save Answer.")
    @PostMapping
    fun saveAnswer(@RequestBody answerEntity: AnswerEntity): AnswerEntity {
        return answerUseCase.saveAnswer(answerEntity)
    }
}