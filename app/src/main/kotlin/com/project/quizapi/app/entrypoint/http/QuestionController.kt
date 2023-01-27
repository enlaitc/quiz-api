package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.app.dataprovider.oracle.model.Question
import com.project.quizapi.app.entrypoint.http.data.RequestSaveQuestion
import com.project.quizapi.app.dataprovider.oracle.repository.QuestionRepository
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionController(val repository: QuestionRepository, val quizRepository: QuizRepository) {

    @PostMapping
    fun saveQuestion(@RequestBody question: RequestSaveQuestion): Question {

        val parseQuestion = question.converter(quizRepository);
        return repository.save(parseQuestion)
    }

    @GetMapping("/id/{questionId}")
    fun getQuestion(@PathVariable questionId: Long): Question {
        return repository.findById(questionId).get();
    }
}