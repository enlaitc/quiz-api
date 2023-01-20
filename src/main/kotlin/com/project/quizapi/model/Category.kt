package com.project.quizapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_quiz_category")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCategory: Long,

    @Column(name = "des_name")
    var name: String,

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    var questions: List<Question>?
)
