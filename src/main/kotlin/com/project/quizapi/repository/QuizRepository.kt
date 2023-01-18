package com.project.quizapi.repository

import com.project.quizapi.model.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepository : JpaRepository<Quiz, Long>{
}