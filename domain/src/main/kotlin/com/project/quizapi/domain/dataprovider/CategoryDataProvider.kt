package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.CategoryEntity

interface CategoryDataProvider {
    fun findCategories(): MutableList<CategoryEntity>
    fun findCategoryById(idCategory: Long): CategoryEntity
    fun saveCategory(categoryEntity: CategoryEntity): CategoryEntity
}