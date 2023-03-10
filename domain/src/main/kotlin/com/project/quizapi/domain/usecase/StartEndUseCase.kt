package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.QuestionEntity
import com.project.quizapi.domain.entity.vo.*
import org.springframework.stereotype.Service

@Service
class StartEndUseCase(
    private val reviewUseCase: ReviewUseCase,
    private val questionUseCase: QuestionUseCase
) {

    fun startQuiz(requestSaveReview: RequestSaveReviewEntity): MutableList<ResponseQuestionEntity> {
        val idReview = reviewUseCase.startQuizSaveReview(requestSaveReview).idReview
        val questions = questionUseCase.findQuestionByCategories(requestSaveReview.categoriesId)
        val questionsResponse = transform(questions, requestSaveReview)

        return questionsResponse.map { question ->
            ResponseQuestionEntity(
                idReview = idReview!!,
                question = question.question,
                questionType = question.questionType,
                questionDifficult = question.questionDifficult,
                categories = question.categories?.map { category ->
                    ResponseCategoryEntity(
                        category.idCategory!!,
                        category.name
                    )
                },
                answers = question.answers?.map { answer ->
                    ResponseAnswerEntity(
                        answer.answer,
                        answer.status
                    )
                })
        }
            .shuffled()
            .toMutableList()
    }

    fun endQuiz(requestUpdateReview: RequestUpdateReviewEntity): ResponseReviewEntity {
        val reviewEntity = reviewUseCase.endQuizUpdateReview(requestUpdateReview)

        return ResponseReviewEntity(
            idReview = reviewEntity.idReview!!,
            quizName = reviewEntity.idQuiz.name,
            user = reviewEntity.user,
            score = reviewEntity.score,
            difficult = reviewEntity.difficult,
            duration = reviewEntity.duration.toLocalTime(),
            questions = reviewEntity.questions,
            start = reviewEntity.start,
            end = reviewEntity.end!!,
            categories = reviewEntity.categories!!.map { category ->
                ResponseCategoryEntity(
                    category.idCategory!!,
                    category.name
                )
            }
        )
    }

    private fun transform(
        questions: List<QuestionEntity>, requestSaveReview: RequestSaveReviewEntity
    ): MutableList<QuestionEntity> {
        val normalQuestions =
            questions.filter { question -> question.questionDifficult == DifficultCategoryEnum.NORMAL }.asSequence()
                .shuffled()
                .take((requestSaveReview.difficult.percentNormal * requestSaveReview.qtQuestions / 100).toInt())

        val dificilQuestions =
            questions.filter { question -> question.questionDifficult == DifficultCategoryEnum.DIFICIL }.asSequence()
                .shuffled()
                .take((requestSaveReview.difficult.percentDificil * requestSaveReview.qtQuestions / 100).toInt())

        return (normalQuestions + dificilQuestions).toMutableList()
    }
}