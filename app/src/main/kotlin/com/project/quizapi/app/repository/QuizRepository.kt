package com.project.quizapi.app.repository

import com.project.quizapi.app.model.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepository : JpaRepository<Quiz, Long>{
}