package com.project.quizapi.controller

import com.project.quizapi.model.Review
import com.project.quizapi.model.vo.RequestSaveReview
import com.project.quizapi.repository.QuizRepository
import com.project.quizapi.repository.ReviewRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.LocalTime

@RestController
@RequestMapping("/review")
class ReviewController( val repository: ReviewRepository, val quizRepository: QuizRepository) {

    @PostMapping
    fun saveReview(@RequestBody review: RequestSaveReview): Review{

        val parseReview= Review(
            idReview = null,
            idQuiz = quizRepository.findById(review.idQuiz).get(),
            user = review.user,
            score = 10,
            difficult = review.difficult,
            duration = LocalTime.now(),
            questions = 10,
            start = LocalDateTime.now(),
            end = LocalDateTime.now()
        )

        return repository.save(parseReview);
    }
}