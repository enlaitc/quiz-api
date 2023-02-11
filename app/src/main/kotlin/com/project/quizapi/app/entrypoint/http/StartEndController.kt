package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.entity.vo.ResponseQuestion
import com.project.quizapi.domain.usecase.QuizUseCase
import com.project.quizapi.domain.usecase.StartEndUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "Start-End")
@RestController
@RequestMapping("api")
class StartEndController(private val startEndUseCase: StartEndUseCase) {

    @Operation(summary = "Start Quiz.")
    @PostMapping("/start")
    fun startQuiz(@RequestBody requestSaveReview: RequestSaveReviewEntity): MutableList<ResponseQuestion> {
        return startEndUseCase.startQuiz(requestSaveReview)
    }

    @Operation(summary = "End Quiz.")
    @PutMapping("/end")
    fun endQuiz(@RequestBody requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity {
        return startEndUseCase.endQuiz(requestUpdateReview)
    }
}