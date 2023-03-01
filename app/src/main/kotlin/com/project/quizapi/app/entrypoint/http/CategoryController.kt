package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.usecase.CategoryUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Category")
@RestController
@RequestMapping("category/api")
class CategoryController(
    private val categoryUseCase: CategoryUseCase
) {

    @Operation(summary = "Save Category.")
    @PostMapping
    fun saveCategory(name: String): CategoryEntity{
        return categoryUseCase.saveCategory(name)
    }
}