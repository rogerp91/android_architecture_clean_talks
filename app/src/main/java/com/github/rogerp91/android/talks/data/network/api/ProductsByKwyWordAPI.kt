package com.github.rogerp91.android.talks.data.network.api

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rpatino on oct/2019
 */
interface ProductsByKwyWordAPI {

    @GET("sites/MLA/search/")
    fun getCategoriesAsync(@Query("q") q: String): Deferred<ProductsDto>
}