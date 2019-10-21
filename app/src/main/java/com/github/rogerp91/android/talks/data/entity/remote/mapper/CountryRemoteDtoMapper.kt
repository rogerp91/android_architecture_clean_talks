package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.CountryDto
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper
import com.github.rogerp91.android.talks.domain.model.Country

/**
 * Created by rpatino on oct/2019
 */
class CountryRemoteDtoMapper : LocalDatabaseMapper<CountryDto, Country> {

    override fun asDomainModel(dto: CountryDto?): Country {
        return Country(
            id = dto?.id,
            name = dto?.name
        )
    }
}