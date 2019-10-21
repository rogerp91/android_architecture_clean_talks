package com.github.rogerp91.android.talks.data.network

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto

/**
 * Created by rpatino on oct/2019
 */
interface CategoryRestAPI {

    suspend fun getCategories(): List<CategoryDto>

}