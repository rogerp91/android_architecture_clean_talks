package com.github.rogerp91.android.talks.data.repository.datasource.remote

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto
import com.github.rogerp91.android.talks.data.network.CategoryRestAPI
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class CategoryRemoteDataStore @Inject constructor(
    private val restAPI: CategoryRestAPI
) : CategoryDataStore {

    override suspend fun getCategories(): List<CategoryDto> {
        return restAPI.getCategories()
    }
}