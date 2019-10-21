package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.StateDto
import com.github.rogerp91.android.talks.domain.model.State
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class StateRemoteDtoMapper : LocalDatabaseMapper<StateDto, State> {

    override fun asDomainModel(dto: StateDto?): State {
        return State(
            id = dto?.id,
            name = dto?.name
        )
    }
}