package com.project.quizapi.app.entrypoint.http.data

import com.project.quizapi.app.dataprovider.oracle.model.Category
import com.project.quizapi.app.dataprovider.oracle.model.Question
import com.project.quizapi.app.dataprovider.oracle.model.DifficultCategory
import com.project.quizapi.app.dataprovider.oracle.model.QuestionType
import com.project.quizapi.app.dataprovider.oracle.repository.QuizRepository
import java.time.LocalDateTime

data class RequestSaveQuestion(
    val idQuiz: Long,
    val question: String,
    val questionType: QuestionType,
    val questionDifficult: DifficultCategory,
    val categories: List<Category>
) {


    fun converter(quizRepo: QuizRepository): Question {
        return Question(
            idQuestion = null,
            idQuiz = quizRepo.findById(idQuiz).get(),
            question = question,
            questionType = questionType,
            questionDifficult =questionDifficult,
            category = 1,
            creation = LocalDateTime.now(),
            update = LocalDateTime.now(),
            categories = categories,
            answers = null
        );
    }
}
