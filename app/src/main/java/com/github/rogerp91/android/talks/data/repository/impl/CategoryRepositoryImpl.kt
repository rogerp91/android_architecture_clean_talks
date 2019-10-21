package com.github.rogerp91.android.talks.data.repository.impl

import com.github.rogerp91.android.talks.data.entity.remote.mapper.CategoryRemoteDtoMapper
import com.github.rogerp91.android.talks.data.repository.datasource.local.CategoryDao
import com.github.rogerp91.android.talks.data.repository.datasource.remote.CategoryDataStore
import com.github.rogerp91.android.talks.domain.model.Category
import com.github.rogerp91.android.talks.domain.repository.CategoryRepository
import com.github.rogerp91.android.talks.data.entity.local.mapper.CategoryDatabaseDataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class CategoryRepositoryImpl @Inject constructor(
    private val dataStore: CategoryDataStore,
    private val categoryDAO: CategoryDao,
    private val remoteMapper: CategoryRemoteDtoMapper,
    private val localMapper: CategoryDatabaseDataMapper
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return localMapper.asDomainModel(categoryDAO.getCategories())
    }

    override suspend fun refreshCategories() {
        withContext(Dispatchers.IO) {
            saveCategory(remoteMapper.asDomainModel(dataStore.getCategories()))
        }
    }

    private fun saveCategory(categories: List<Category>) {
        if (categories.isNotEmpty()) {
            val categoriesDatabase = localMapper.asDatabaseModel(categories)
            categoryDAO.insertAll(*categoriesDatabase)
        }
    }
}