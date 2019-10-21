package com.github.rogerp91.android.talks.data.repository.datasource.remote

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto
import com.github.rogerp91.android.talks.data.network.ProductsByKeyWordRestAPI
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class GetProductsByKeyWordRemoteDataStore @Inject constructor(
    private val restAPI: ProductsByKeyWordRestAPI
) : GetProductsByKeyWordDataStore {

    override suspend fun getProductsByKeyWord(keyWord: String): ProductsDto {
        return restAPI.getProductsByKeyWord(keyWord)
    }
}