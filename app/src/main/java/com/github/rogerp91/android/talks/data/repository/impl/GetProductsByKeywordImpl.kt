package com.github.rogerp91.android.talks.data.repository.impl

import com.github.rogerp91.android.talks.data.entity.remote.mapper.ProductRemoteDtoMapper
import com.github.rogerp91.android.talks.data.repository.datasource.remote.GetProductsByKeyWordDataStore
import com.github.rogerp91.android.talks.domain.model.Products
import com.github.rogerp91.android.talks.domain.repository.GetProductsByKeyword
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class GetProductsByKeywordImpl @Inject constructor(
    private val dataStore: GetProductsByKeyWordDataStore,
    private val mapper: ProductRemoteDtoMapper
) : GetProductsByKeyword {

    override suspend fun getProductsByKeyword(keyWord: String): Products {
        return mapper.asDomainModel(dataStore.getProductsByKeyWord(keyWord))
    }
}