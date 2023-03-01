package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.CategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import org.springframework.stereotype.Service

@Service
class CategoryUseCase(
    private val categoryDataProvider: CategoryDataProvider
) {

    fun findCategoryById(idCategory: Long): CategoryEntity{
        return categoryDataProvider.findCategoryById(idCategory)
    }

    fun saveCategory(name: String): CategoryEntity{
        val categoryEntity = CategoryEntity(
            idCategory = null,
            name = name,
            questions = null,
            reviews = null
        )

        return categoryDataProvider.saveCategory(categoryEntity)
    }
}