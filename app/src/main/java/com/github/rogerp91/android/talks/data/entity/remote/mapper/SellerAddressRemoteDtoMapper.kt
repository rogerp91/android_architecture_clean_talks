package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.SellerAddressDto
import com.github.rogerp91.android.talks.domain.model.SellerAddress
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class SellerAddressRemoteDtoMapper @Inject constructor(
    private val countryRemoteDataMapper: CountryRemoteDtoMapper,
    private val stateRemoteDataMapper: StateRemoteDtoMapper,
    private val cityRemoteDataMapper: CityRemoteDtoMapper
) : LocalDatabaseMapper<SellerAddressDto, SellerAddress> {

    override fun asDomainModel(dto: SellerAddressDto?): SellerAddress {
        return SellerAddress(
            id = dto?.id,
            comment = dto?.comment,
            address_line = dto?.address_line,
            zip_code = dto?.zip_code,
            country = countryRemoteDataMapper.asDomainModel(dto?.countryDto),
            state = stateRemoteDataMapper.asDomainModel(dto?.stateDto),
            city = cityRemoteDataMapper.asDomainModel(dto?.cityEntity),
            latitude = dto?.latitude,
            longitude = dto?.longitude
        )
    }
}