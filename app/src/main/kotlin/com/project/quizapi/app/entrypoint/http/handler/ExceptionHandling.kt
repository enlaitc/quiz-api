package com.project.quizapi.app.entrypoint.http.handler

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandling {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponseGeneric>{
        val errorDetails = ErrorResponseGeneric(
            message = ex.message,
            time = Date(),
            details = "Value not accepted" ,
            status = HttpStatus.BAD_REQUEST.value()
        )

        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFound(ex: EntityNotFoundException): ResponseEntity<ErrorResponseGeneric>{
        val errorDetails = ErrorResponseGeneric(
            message = ex.message,
            time = Date(),
            details = "Data not found" ,
            status = HttpStatus.BAD_REQUEST.value()
        )

        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}