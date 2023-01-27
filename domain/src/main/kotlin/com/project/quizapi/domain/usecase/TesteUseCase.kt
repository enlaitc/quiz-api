package com.project.quizapi.domain.usecase

import com.project.quizapi.domain.dataprovider.FindCategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import org.springframework.stereotype.Service

@Service
class TesteUseCase(private val findCategoriesDataProvider: FindCategoryDataProvider) {

    fun teste():String {
        return "hello world"
    }

    fun db():MutableList<CategoryEntity> {
        return findCategoriesDataProvider.findCategories()
    }
}