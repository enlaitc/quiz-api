package com.project.quizapi.app.dataprovider.oracle.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.project.quizapi.domain.entity.CategoryEntity
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

fun Category.toEntity(): CategoryEntity {

    return CategoryEntity(
        idCategory = this.idCategory,
        name = this.name,
        questions = this.questions
    )
}

