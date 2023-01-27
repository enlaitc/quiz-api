package com.project.quizapi.domain.dataprovider

import com.project.quizapi.domain.entity.CategoryEntity

interface FindCategoryDataProvider {
    fun findCategories(): MutableList<CategoryEntity>
}