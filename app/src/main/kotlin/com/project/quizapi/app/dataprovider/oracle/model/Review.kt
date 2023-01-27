package com.project.quizapi.app.dataprovider.oracle.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.LocalTime

@Entity
@Table(name = "tb_quiz_review")
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idReview: Long?,

    @OneToOne
    @JoinColumn(name = "id_quiz", referencedColumnName = "idQuiz")
    var idQuiz: Quiz,

    @Column(name = "des_user")
    var user: String,

    @Column(name = "int_score")
    var score: Long,

    @Column(name = "des_difficult")
    var difficult: DifficultCategory,

    @Column(name = "time_duration")
    var duration: LocalTime,

    @Column(name = "int_questions")
    var questions: Long,

    @Column(name = "dat_creation")
    var start: LocalDateTime,

    @Column(name = "dat_end")
    var end: LocalDateTime

)
