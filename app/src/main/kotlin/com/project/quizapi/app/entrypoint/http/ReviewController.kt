package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.app.dataprovider.oracle.model.Review
import com.project.quizapi.app.entrypoint.http.data.RequestSaveReview
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import com.project.quizapi.app.dataprovider.oracle.repository.ReviewRepository
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.usecase.ReviewUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.LocalTime

@RestController
@RequestMapping("/review")
class ReviewController(val reviewUseCase: ReviewUseCase) {

    @GetMapping("/id/{idReview}")
    fun buscaReviewPorId(idReview: Long): ReviewEntity{
        return reviewUseCase.findReviewById(idReview)
    }

    @PostMapping
    fun salvaReview(requestSaveReview: RequestSaveReviewEntity): ReviewEntity{
        return reviewUseCase.saveReview(requestSaveReview)
    }

}