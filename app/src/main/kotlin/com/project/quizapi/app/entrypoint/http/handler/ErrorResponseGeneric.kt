package com.project.quizapi.app.entrypoint.http.handler

import java.util.*

data class ErrorResponseGeneric(
    val message: String?,
    val time: Date,
    val details: String?,
    val status: Int
)
