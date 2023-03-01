package com.project.quizapi.app.dataprovider.oracle

import com.project.quizapi.app.dataprovider.oracle.model.Category
import com.project.quizapi.app.dataprovider.oracle.model.toCategory
import com.project.quizapi.app.dataprovider.oracle.model.toEntity
import com.project.quizapi.app.dataprovider.oracle.model.toEntity2
import com.project.quizapi.app.dataprovider.oracle.repository.CategoryRepository
import com.project.quizapi.domain.dataprovider.CategoryDataProvider
import com.project.quizapi.domain.entity.CategoryEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class CategoryPostgresProvider(private val repository: CategoryRepository): CategoryDataProvider {

    override fun findCategories(): MutableList<CategoryEntity> {
        val listCategories = repository.findAll().map { it -> it.toEntity2() }

        return listCategories.toMutableList()
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