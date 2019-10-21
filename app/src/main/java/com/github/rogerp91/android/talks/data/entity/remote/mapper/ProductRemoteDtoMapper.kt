package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.ProductsDto
import com.github.rogerp91.android.talks.domain.model.Products
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class ProductRemoteDtoMapper @Inject constructor(
    private val pagingMapper: PagingRemoteDtoMapper,
    private val resultsRemoteDtoMapper: ResultsRemoteDtoMapper
) : LocalDatabaseMapper<ProductsDto, Products> {

    override fun asDomainModel(dto: ProductsDto?): Products {
        return Products(
            site_id = dto!!.site_id,
            query = dto.query,
            paging = pagingMapper.asDomainModel(dto.paging),
            results = resultsRemoteDtoMapper.asDomainModel(dto.results)
        )
    }
}