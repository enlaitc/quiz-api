package com.project.quizapi.app.repository

import com.project.quizapi.app.model.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long>{
}