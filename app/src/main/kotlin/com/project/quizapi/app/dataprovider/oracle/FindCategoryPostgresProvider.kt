package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.repository.CategoryRepository
import com.project.quizapi.domain.dataprovider.FindCategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import org.springframework.stereotype.Component

@Component
class FindCategoryPostgresProvider(private val categoryRepository: CategoryRepository): FindCategoryDataProvider {

    override fun findCategories(): MutableList<CategoryEntity> {
        return categoryRepository.findAll().first().toEntity()
    }

//    fun findCategoryById(): CategoryEntity {
//        return categoryRepository.findById(1)
//    }
}