package com.github.rogerp91.android.talks.data.network

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto
import com.github.rogerp91.android.talks.data.network.api.ProductsByKwyWordAPI
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class ProductsByKeyWordRestAPIImpl @Inject constructor(
    private val api: ProductsByKwyWordAPI
) : ProductsByKeyWordRestAPI {

    override suspend fun getProductsByKeyWord(keyWord: String): ProductsDto {
        return api.getCategoriesAsync(keyWord).await()
    }
}