package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.*
import com.project.quizapi.app.dataprovider.oracle.repository.CategoryRepository
import com.project.quizapi.domain.dataprovider.CategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.entity.vo.ResponseCategoryEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class CategoryPostgresProvider(private val repository: CategoryRepository): CategoryDataProvider {

    override fun findCategories(): List<ResponseCategoryEntity> {
        return repository.findAll().map { it -> it.toResponseEntity() }
    }

    override fun findCategoryById(idCategory: Long): CategoryEntity {
        val category = repository.findById(idCategory)
        if(category.isEmpty) throw EntityNotFoundException("Category not found")
        return category.get().toEntity2()
    }

    override fun saveCategory(categoryEntity: CategoryEntity): CategoryEntity {
        return repository.save(categoryEntity.toCategory()).toEntity2()
    }
}