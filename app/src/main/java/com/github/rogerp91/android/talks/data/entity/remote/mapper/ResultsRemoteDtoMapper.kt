package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.ResultsDto
import com.github.rogerp91.android.talks.domain.model.Results
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class ResultsRemoteDtoMapper @Inject constructor(
    private val sellerRemoteDataMapper: SellerRemoteDtoMapper,
    private val installmentsRemoteDataMapper: InstallmentsRemoteDtoMapper,
    private val addressRemoteDataMapper: AddressRemoteDtoMapper,
    private val shippingRemoteDataMapper: ShippingRemoteDtoMapper,
    private val sellerAddressRemoteDataMapper: SellerAddressRemoteDtoMapper,
    private val attributesRemoteDataMapper: AttributesRemoteDtoMapper,
    private val differentialPricingRemoteDataMapper: DifferentialPricingRemoteDtoMapper
) : LocalDatabaseMapper<List<ResultsDto>, List<Results>> {

    override fun asDomainModel(dto: List<ResultsDto>?): List<Results> {
        return dto!!.map {
            Results(
                id = it.id,
                site_id = it.site_id,
                title = it.title,
                seller = sellerRemoteDataMapper.asDomainModel(it.seller),
                price = it.price,
                currency_id = it.currency_id,
                available_quantity = it.available_quantity,
                sold_quantity = it.sold_quantity,
                buying_mode = it.buying_mode,
                listing_type_id = it.listing_type_id,
                stop_time = it.stop_time,
                condition = it.condition,
                permalink = it.permalink,
                thumbnail = it.thumbnail,
                accepts_mercadopago = it.accepts_mercadopago,
                installments = installmentsRemoteDataMapper.asDomainModel(it.installmentsDto),
                address = addressRemoteDataMapper.asDomainModel(it.addressDto),
                shipping = shippingRemoteDataMapper.asDomainModel(it.shippingDto),
                seller_address = sellerAddressRemoteDataMapper.asDomainModel(it.seller_addressDto),
                attributes = attributesRemoteDataMapper.asDomainModel(it.attributes),
                differential_pricing = differentialPricingRemoteDataMapper.asDomainModel(it.differential_pricingDto),
                original_price = it.original_price,
                category_id = it.category_id,
                official_store_id = it.official_store_id,
                catalog_product_id = it.catalog_product_id,
                tags = it.tags,
                catalog_listing = it.catalog_listing
            )
        }
    }
}