package com.project.quizapi.app.dataprovider.oracle.repository

import com.project.quizapi.app.dataprovider.oracle.model.Category
import com.project.quizapi.domain.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Category, Long>{
    override fun findById(id:Long): Optional<Category>
    override fun findAll(): MutableList<Category>
}