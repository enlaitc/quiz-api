package com.project.quizapi.app.dataprovider.oracle.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.project.quizapi.domain.entity.AnswerEntity
import com.project.quizapi.domain.entity.QuestionEntity
import jakarta.persistence.*

@Entity
@Table(name = "tb_quiz_answer")
data class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAnswer: Long?,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_question")
    var question: Question,

    @Column( name = "des_answer")
    var answer: String,

    @Column( name = "boo_status")
    var status: Boolean
)

fun Answer.toEntity(): AnswerEntity {

    return AnswerEntity(
        idAnswer = this.idAnswer,
        question = this.question.idQuestion!!,
        answer = this.answer,
        status = this.status
    )
}