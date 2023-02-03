package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity2
import com.project.quizapi.app.dataprovider.oracle.repository.CategoryRepository
import com.project.quizapi.domain.dataprovider.CategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryPostgresProvider(private val categoryRepository: CategoryRepository): CategoryDataProvider {

    override fun findCategories(): MutableList<CategoryEntity> {
        val listCategories = categoryRepository.findAll().map { it -> it.toEntity2() }

        return listCategories.toMutableList()
    }

    override fun findCategoryById(idCategory: Long): CategoryEntity {
        return categoryRepository.findById(idCategory).get().toEntity2()
    }
}