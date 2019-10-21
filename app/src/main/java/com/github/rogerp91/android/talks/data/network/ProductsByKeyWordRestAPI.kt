package com.github.rogerp91.android.talks.data.network

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto

/**
 * Created by rpatino on oct/2019
 */
interface ProductsByKeyWordRestAPI {

    suspend fun getProductsByKeyWord(keyWord: String): ProductsDto

}