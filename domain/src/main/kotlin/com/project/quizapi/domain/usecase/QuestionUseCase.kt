package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.QuestionDataProvider
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.vo.RequestSaveQuestionEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class QuestionUseCase(
    private val questionDataProvider: QuestionDataProvider,
    private val categoryUseCase: CategoryUseCase,
    private val quizUseCase: QuizUseCase
) {

    fun findQuestionByCategories(categoriesId: List<Long>): MutableList<QuestionEntity>{
        val listCategories = categoriesId.map { categoryUseCase.findCategoryById(it) }

        return questionDataProvider.findQuestionsByCategories(listCategories)
    }

    fun findQuestionById(questionId: Long): QuestionEntity{
        return questionDataProvider.findQuestionById(questionId)
    }

    fun saveQuestion(requestQuestion: RequestSaveQuestionEntity): QuestionEntity{
        val questionEntity = QuestionEntity(
            idQuestion = null,
            idQuiz = quizUseCase.findQuizById(requestQuestion.idQuiz),
            question = requestQuestion.question,
            questionType = requestQuestion.questionType,
            questionDifficult = requestQuestion.questionDifficult,
            creation = LocalDateTime.now(),
            update = null,
            categories = requestQuestion.categoriesId.map { categoryUseCase.findCategoryById(it) },
            answers = null
        )

        return questionDataProvider.saveQuestion(questionEntity)
    }
}