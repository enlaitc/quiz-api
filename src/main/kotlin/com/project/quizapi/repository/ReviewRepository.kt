package com.project.quizapi.repository

import com.project.quizapi.model.Quiz
import com.project.quizapi.model.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long>{
}