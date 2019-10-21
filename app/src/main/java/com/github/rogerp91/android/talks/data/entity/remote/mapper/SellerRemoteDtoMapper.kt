package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.SellerDto
import com.github.rogerp91.android.talks.domain.model.Seller
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class SellerRemoteDtoMapper : LocalDatabaseMapper<SellerDto, Seller> {

    override fun asDomainModel(dto: SellerDto?): Seller {
        return Seller(
            id = dto?.id,
            power_seller_status = dto?.power_seller_status,
            car_dealer = dto?.car_dealer,
            real_estate_agency = dto?.real_estate_agency,
            tags = dto?.tags
        )
    }
}