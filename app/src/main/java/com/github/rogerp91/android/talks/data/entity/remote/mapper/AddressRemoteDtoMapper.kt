package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.AddressDto
import com.github.rogerp91.android.talks.domain.model.Address
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class AddressRemoteDtoMapper : LocalDatabaseMapper<AddressDto, Address> {

    override fun asDomainModel(dto: AddressDto?): Address {
        return Address(
            state_id = dto?.state_id,
            state_name = dto?.state_name,
            city_id = dto?.city_id,
            city_name = dto?.city_name
        )
    }

}