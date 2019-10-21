package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.DifferentialPricingDto
import com.github.rogerp91.android.talks.domain.model.DifferentialPricing
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class DifferentialPricingRemoteDtoMapper :
    LocalDatabaseMapper<DifferentialPricingDto, DifferentialPricing> {

    override fun asDomainModel(dto: DifferentialPricingDto?): DifferentialPricing {
        return DifferentialPricing(
            id = dto?.id
        )
    }
}