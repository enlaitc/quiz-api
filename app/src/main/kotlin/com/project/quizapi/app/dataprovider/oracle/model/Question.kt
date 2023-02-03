package com.project.quizapi.app.dataprovider.oracle.model

import com.project.quizapi.domain.entity.*
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tb_quiz_question")
data class Question(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idQuestion: Long?,

    @OneToOne
    @JoinColumn(name = "id_quiz", referencedColumnName = "idQuiz")
    var idQuiz: Quiz,

    @Column(name = "des_question")
    var question: String,

    @Column(name = "des_question_type")
    var questionType: QuestionTypeEnum,

    @Column(name = "des_question_difficult")
    var questionDifficult: DifficultCategoryEnum,

    @Column(name = "dat_creation")
    var creation: LocalDateTime,

    @Column(name = "dat_update")
    var update: LocalDateTime,

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
        ]
    )
    @JoinTable(
        name = "ta_question_category",
        joinColumns = [JoinColumn(name = "question_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: List<Category>?,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "question", fetch = FetchType.EAGER)
    var answers: List<Answer>?

)

fun Question.toEntity(): QuestionEntity {

    return QuestionEntity(
        idQuestion = this.idQuestion,
        idQuiz = this.idQuiz.toEntity(),
        question = this.question,
        questionType = this.questionType,
        questionDifficult = this.questionDifficult,
        creation = this.creation,
        update = this.update,
        categories = this.categories!!.map { it -> it.toEntity2() },
        answers = this.answers!!.map { it -> it.toEntity() }
    )
}

fun QuestionEntity.toQuestion(): Question {

    return Question(
        idQuestion = this.idQuestion,
        idQuiz = this.idQuiz.toQuiz(),
        question = this.question,
        questionType = this.questionType,
        questionDifficult = this.questionDifficult,
        creation = this.creation,
        update = this.update,
        categories = this.categories!!.map { it -> it.toCategory() },
        answers = null
    )
}
