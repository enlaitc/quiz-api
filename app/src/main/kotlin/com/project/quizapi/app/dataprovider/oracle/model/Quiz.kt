package com.project.quizapi.app.dataprovider.oracle.model

import com.project.quizapi.domain.entity.QuizEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "tb_quiz")
data class Quiz(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idQuiz: Long?,

    @Column(name = "des_name")
    var name: String,

    @Column(name = "dat_creation")
    var creation: LocalDate,

    )

fun Quiz.toEntity(): QuizEntity {

    return QuizEntity(
        idQuiz = this.idQuiz,
        name = this.name,
        creation = this.creation
    )
}