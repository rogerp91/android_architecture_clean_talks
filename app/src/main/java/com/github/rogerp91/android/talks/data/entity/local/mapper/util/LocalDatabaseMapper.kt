package com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util

/**
 * Created by rpatino on oct/2019
 */
interface LocalDatabaseMapper<DB, D> {

    fun asDomainModel(database: DB?): D
}