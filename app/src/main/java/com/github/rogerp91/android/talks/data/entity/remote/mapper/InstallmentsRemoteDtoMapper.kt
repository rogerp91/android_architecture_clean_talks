package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.InstallmentsDto
import com.github.rogerp91.android.talks.domain.model.Installments
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class InstallmentsRemoteDtoMapper : LocalDatabaseMapper<InstallmentsDto, Installments> {

    override fun asDomainModel(dto: InstallmentsDto?): Installments {
        return Installments(
            quantity = dto?.quantity,
            amount = dto?.amount,
            rate = dto?.rate,
            currency_id = dto?.currency_id
        )
    }
}