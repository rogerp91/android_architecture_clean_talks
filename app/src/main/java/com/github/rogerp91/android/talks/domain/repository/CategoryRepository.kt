package com.github.rogerp91.android.talks.domain.repository

import com.github.rogerp91.android.talks.domain.model.Category

interface CategoryRepository {

    suspend fun refreshCategories()

    suspend fun getCategories(): List<Category>
}