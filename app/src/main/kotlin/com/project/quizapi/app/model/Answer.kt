package com.project.quizapi.app.model

import com.fasterxml.jackson.annotation.JsonIgnore
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
