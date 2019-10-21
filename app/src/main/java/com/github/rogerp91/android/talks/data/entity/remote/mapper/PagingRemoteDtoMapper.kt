package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.PagingDto
import com.github.rogerp91.android.talks.domain.model.Paging
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class PagingRemoteDtoMapper : LocalDatabaseMapper<PagingDto, Paging> {

    override fun asDomainModel(dto: PagingDto?): Paging {
        return Paging(
            total = dto!!.total,
            offset = dto.offset,
            limit = dto.limit,
            primary_results = dto.primary_results
        )
    }

}