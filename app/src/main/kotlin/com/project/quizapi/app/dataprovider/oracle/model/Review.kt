package com.project.quizapi.app.dataprovider.oracle.model

import com.project.quizapi.domain.entity.DifficultCategoryEnum
import com.project.quizapi.domain.entity.ReviewEntity
import jakarta.persistence.*
import org.hibernate.Hibernate
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
    var difficult: DifficultCategoryEnum,

    @Column(name = "time_duration")
    var duration: LocalTime,

    @Column(name = "int_questions")
    var questions: Long,

    @Column(name = "dat_creation")
    var start: LocalDateTime,

    @Column(name = "dat_end")
    var end: LocalDateTime?,

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [
            //CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
        ]
    )
    @JoinTable(
        name = "ta_review_category",
        joinColumns = [JoinColumn(name = "review_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: List<Category>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Review

        return idReview != null && idReview == other.idReview
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idReview = $idReview , idQuiz = $idQuiz , user = $user , score = $score , difficult = $difficult , duration = $duration , questions = $questions , start = $start , end = $end )"
    }
}

fun Review.toEntity(): ReviewEntity {

    return ReviewEntity(
        idReview = this.idReview,
        idQuiz = this.idQuiz.toEntity(),
        user = this.user,
        score = this.score,
        difficult = this.difficult,
        duration = this.duration,
        questions = this.questions,
        start = this.start,
        end = this.end,
        categories = this.categories!!.map { it -> it.toEntity2() }
    )
}

fun ReviewEntity.toReview(): Review {

    return Review(
        idReview = this.idReview,
        idQuiz = this.idQuiz.toQuiz(),
        user = this.user,
        score = this.score,
        difficult = this.difficult,
        duration = this.duration,
        questions = this.questions,
        start = this.start,
        end = this.end,
        categories = this.categories!!.map { it -> it.toCategory() }
    )
}
