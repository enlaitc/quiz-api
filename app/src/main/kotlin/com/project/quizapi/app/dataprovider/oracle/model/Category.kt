package com.project.quizapi.app.dataprovider.oracle.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.project.quizapi.domain.entity.CategoryEntity
import jakarta.persistence.*

@Entity
@Table(name = "tb_quiz_category")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCategory: Long?,

    @Column(name = "des_name")
    var name: String,

    @JsonIgnore
    @ManyToMany(
        mappedBy = "categories", fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
        ]
    )
    var questions: List<Question>?,

    @JsonIgnore
    @ManyToMany(
        mappedBy = "categories", fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
        ]
    )
    var reviews: List<Review>?
)

fun Category.toEntity(): CategoryEntity {

    return CategoryEntity(
        idCategory = this.idCategory,
        name = this.name,
        questions = this.questions!!.map { it -> it.toEntity() },
        reviews = this.reviews!!.map { it -> it.toEntity() }
    )
}

fun Category.toEntity2(): CategoryEntity {

    return CategoryEntity(
        idCategory = this.idCategory,
        name = this.name,
        questions = null,
        reviews = null
    )
}

fun CategoryEntity.toCategory(): Category {

    return Category(
        idCategory = this.idCategory,
        name = this.name,
        questions = this.questions?.map { it.toQuestion() },
        reviews = this.reviews?.map { it.toReview() }
    )
}

