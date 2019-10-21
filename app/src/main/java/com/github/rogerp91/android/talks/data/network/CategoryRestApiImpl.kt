package com.github.rogerp91.android.talks.data.network

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto
import com.github.rogerp91.android.talks.data.network.api.CategoryAPI
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class CategoryRestApiImpl @Inject constructor(
    private val api: CategoryAPI
) : CategoryRestAPI {

    override suspend fun getCategories(): List<CategoryDto> {
        return api.getCategoriesAsync().await()
    }
}