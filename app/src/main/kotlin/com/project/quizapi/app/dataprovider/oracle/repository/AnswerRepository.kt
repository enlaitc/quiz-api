package com.project.quizapi.app.dataprovider.oracle.repository

import com.project.quizapi.app.dataprovider.oracle.model.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository : JpaRepository<Answer, Long>{
}