package com.github.rogerp91.android.talks.data.repository.datasource.remote

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto

/**
 * Created by rpatino on oct/2019
 */
interface CategoryDataStore {

    suspend fun getCategories(): List<CategoryDto>
}