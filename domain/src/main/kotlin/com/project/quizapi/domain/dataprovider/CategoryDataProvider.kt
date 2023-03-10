package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.vo.ResponseCategoryEntity

interface CategoryDataProvider {
    fun findCategories(): List<ResponseCategoryEntity>
    fun findCategoryById(idCategory: Long): CategoryEntity
    fun saveCategory(categoryEntity: CategoryEntity): CategoryEntity
}