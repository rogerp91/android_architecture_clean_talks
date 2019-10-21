package com.github.rogerp91.android.talks.data.entity.remote.mapper.util

/**
 * Created by rpatino on oct/2019
 */
interface RemoteDtoMapper<R, D> {

    fun asDomainModel(dto: R?): D
}