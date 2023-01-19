package com.project.quizapi.controller

import com.project.quizapi.model.Answer
import com.project.quizapi.model.vo.RequestSaveAnswer
import com.project.quizapi.repository.AnswerRepository
import com.project.quizapi.repository.QuestionRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/answer")
class AnswerController (val repository: AnswerRepository, val questionRepository: QuestionRepository){

    @PostMapping
    fun saveAnswer(@RequestBody answer: RequestSaveAnswer): Answer{

        val parseAnswer = Answer(
            idAnswer = null,
            question = questionRepository.findById(answer.questionId).get(),
            answer = answer.answer,
            status = answer.status
        )

        return repository.save(parseAnswer);
    }
}