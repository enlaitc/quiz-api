package com.project.quizapi.app.repository

import com.project.quizapi.app.model.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository : JpaRepository<Answer, Long>{
}