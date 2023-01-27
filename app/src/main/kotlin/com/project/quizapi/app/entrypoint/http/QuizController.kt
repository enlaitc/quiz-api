package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.app.dataprovider.oracle.model.Quiz
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/quiz")
class QuizController(val repository: QuizRepository) {

    @GetMapping("/id/{idQuiz}")
    fun searchQuizById(@PathVariable idQuiz: Long): Optional<Quiz> {
        return repository.findById(idQuiz);
    }
}