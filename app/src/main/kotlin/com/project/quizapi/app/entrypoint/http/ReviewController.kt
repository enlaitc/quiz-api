package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.usecase.ReviewUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/review")
class ReviewController(val reviewUseCase: ReviewUseCase) {

    @GetMapping("/id/{idReview}")
    fun buscaReviewPorId(idReview: Long): ReviewEntity{
        return reviewUseCase.findReviewById(idReview)
    }

    @PostMapping
    fun salvaReview(requestSaveReview: RequestSaveReviewEntity): ReviewEntity{
        return reviewUseCase.startQuizSaveReview(requestSaveReview)
    }

    @PutMapping
    fun atualizaReview(requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity{
        return reviewUseCase.endQuizUpdateReview(requestUpdateReview)
    }

}