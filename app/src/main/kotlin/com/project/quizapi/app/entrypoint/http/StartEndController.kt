package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.ResponseQuestion
import com.project.quizapi.domain.usecase.QuizUseCase
import com.project.quizapi.domain.usecase.StartEndUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/start")
class StartEndController(private val startEndUseCase: StartEndUseCase) {

    @PostMapping()
    fun startQuiz(@RequestBody requestSaveReview: RequestSaveReviewEntity): MutableList<ResponseQuestion> {
        return startEndUseCase.startQuiz(requestSaveReview)
    }
}