package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.ReviewEntity
import com.project.quizapi.domain.entity.vo.RequestSaveReviewEntity
import com.project.quizapi.domain.entity.vo.RequestUpdateReviewEntity
import com.project.quizapi.domain.entity.vo.ResponseQuestion
import org.springframework.stereotype.Service

@Service
class StartEndUseCase(
    private val reviewUseCase: ReviewUseCase,
    private val questionUseCase: QuestionUseCase
) {

    fun startQuiz(requestSaveReview: RequestSaveReviewEntity): MutableList<ResponseQuestion> {
        val idReview = reviewUseCase.startQuizSaveReview(requestSaveReview).idReview
        val questions = questionUseCase.findQuestionByCategories(requestSaveReview.categories)
        val questionsResponse = transform(questions, requestSaveReview)

        return questionsResponse
            .map { question ->
                ResponseQuestion(
                    idReview = idReview!!,
                    question = question.question,
                    questionType = question.questionType,
                    questionDifficult = question.questionDifficult,
                    categories = question.categories,
                    answers = question.answers
                )
            }
            .shuffled()
            .toMutableList()
    }

    fun endQuiz(requestUpdateReview: RequestUpdateReviewEntity): ReviewEntity{
        return reviewUseCase.endQuizUpdateReview(requestUpdateReview)
    }

    private fun transform(
        questions: MutableList<QuestionEntity>,
        requestSaveReview: RequestSaveReviewEntity
    ): MutableList<QuestionEntity> {
        val questionsNormal = questions
            .filter { question -> question.questionDifficult == DifficultCategoryEnum.NORMAL }
            .asSequence()
            .shuffled()
            .take((requestSaveReview.difficult.percentNormal * requestSaveReview.questions / 100).toInt())

        val questionsDificil = questions
            .filter { question -> question.questionDifficult == DifficultCategoryEnum.DIFICIL }
            .asSequence()
            .shuffled()
            .take((requestSaveReview.difficult.percentDificil * requestSaveReview.questions / 100).toInt())

        return (questionsNormal + questionsDificil).toMutableList()
    }
}