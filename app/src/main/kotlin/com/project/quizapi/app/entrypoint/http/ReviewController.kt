package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.usecase.ReviewUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Review")
@RestController
@RequestMapping("review/api")
class ReviewController(val reviewUseCase: ReviewUseCase) {

    @Operation(summary = "Find Review by ID.")
    @GetMapping("/id/{idReview}")
    fun findReviewById(idReview: Long): ReviewEntity{
        return reviewUseCase.findReviewById(idReview)
    }

    @Operation(summary = "Save Review.")
    @PostMapping
    fun saveReview(requestSaveReview: RequestSaveReviewEntity): ReviewEntity{
        return reviewUseCase.startQuizSaveReview(requestSaveReview)
    }

    @Operation(summary = "Update Review.")
    @PutMapping
    fun updateReview(requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity{
        return reviewUseCase.endQuizUpdateReview(requestUpdateReview)
    }

}