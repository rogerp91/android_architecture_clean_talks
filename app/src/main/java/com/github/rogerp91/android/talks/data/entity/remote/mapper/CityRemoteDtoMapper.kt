package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.CityDto
import com.github.rogerp91.android.talks.domain.model.City
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class CityRemoteDtoMapper : LocalDatabaseMapper<CityDto, City> {

    override fun asDomainModel(dto: CityDto?): City {
        return City(
            id = dto?.id,
            name = dto?.name
        )
    }
}