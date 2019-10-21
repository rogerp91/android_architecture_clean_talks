package com.github.rogerp91.android.talks.data.repository.datasource.remote

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto

/**
 * Created by rpatino on oct/2019
 */
interface GetProductsByKeyWordDataStore {

    suspend fun getProductsByKeyWord(keyWord: String): ProductsDto
}