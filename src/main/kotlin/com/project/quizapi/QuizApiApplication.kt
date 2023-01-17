package com.project.quizapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuizApiApplication

fun main(args: Array<String>) {
	runApplication<QuizApiApplication>(*args)
}
