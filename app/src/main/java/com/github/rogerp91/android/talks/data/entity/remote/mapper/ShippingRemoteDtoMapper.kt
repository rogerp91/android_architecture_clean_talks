package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.ShippingDto
import com.github.rogerp91.android.talks.domain.model.Shipping
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class ShippingRemoteDtoMapper : LocalDatabaseMapper<ShippingDto, Shipping> {

    override fun asDomainModel(dto: ShippingDto?): Shipping {
        return Shipping(
            free_shipping = dto?.free_shipping,
            mode = dto?.mode,
            tags = dto?.tags,
            logistic_type = dto?.logistic_type,
            store_pick_up = dto?.store_pick_up
        )
    }
}