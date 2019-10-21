package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.AttributesDto
import com.github.rogerp91.android.talks.domain.model.Attributes
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class AttributesRemoteDtoMapper : LocalDatabaseMapper<List<AttributesDto>, List<Attributes>> {

    override fun asDomainModel(dto: List<AttributesDto>?): List<Attributes> {
        return dto!!.map {
            Attributes(
                attribute_group_id = it.attribute_group_id,
                attribute_group_name = it.attribute_group_name,
                source = it.source,
                id = it.id,
                name = it.name,
                value_id = it.value_id,
                value_name = it.value_name
            )
        }
    }
}