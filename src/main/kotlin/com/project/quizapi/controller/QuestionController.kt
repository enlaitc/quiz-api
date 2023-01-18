package com.project.quizapi.controller

import com.project.quizapi.model.Question
import com.project.quizapi.model.vo.RequestSaveQuestion
import com.project.quizapi.repository.QuestionRepository
import com.project.quizapi.repository.QuizRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/question")
class QuestionController(val repository:QuestionRepository, val quizRepository: QuizRepository) {

    @PostMapping
    fun saveQuestion(@RequestBody question: RequestSaveQuestion): Question{

        val parseQuestion = Question(
            idQuestion = null,
            idQuiz = quizRepository.findById(question.idQuiz).get(),
            question = question.question,
            questionType = question.questionType,
            questionDifficult = question.questionDifficult,
            category = 1,
            creation = LocalDateTime.now(),
            update = LocalDateTime.now(),
            categories = question.categories
        )

        return repository.save(parseQuestion)
    }
}