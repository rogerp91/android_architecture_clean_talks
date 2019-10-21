package com.github.rogerp91.android.talks.data.network.api

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by rpatino on oct/2019
 */
interface CategoryAPI {
    @GET("sites/MLA/categories")
    fun getCategoriesAsync(
    ): Deferred<List<CategoryDto>>
}