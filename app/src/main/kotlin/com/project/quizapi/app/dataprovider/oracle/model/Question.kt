package com.project.quizapi.app.dataprovider.oracle.model

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
    var questionType: QuestionType,

    @Column(name = "des_question_difficult")
    var questionDifficult: DifficultCategory,

    @Column(name = "dat_creation")
    var creation: LocalDateTime,

    @Column(name = "dat_update")
    var update: LocalDateTime,

    @Column(name = "id_category")
    var category: Long?,

    @ManyToMany
    @JoinTable(
        name = "ta_question_category",
        joinColumns = [JoinColumn(name = "question_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: List<Category>?,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "question")
    var answers: List<Answer>?

    )
