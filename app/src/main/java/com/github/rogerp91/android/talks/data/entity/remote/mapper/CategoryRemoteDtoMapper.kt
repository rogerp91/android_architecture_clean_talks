package com.github.rogerp91.android.talks.data.entity.remote.mapper

import com.github.rogerp91.android.talks.data.entity.remote.CategoryDto
import com.github.rogerp91.android.talks.domain.model.Category
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class CategoryRemoteDtoMapper : LocalDatabaseMapper<List<CategoryDto>, List<Category>> {

    override fun asDomainModel(dto: List<CategoryDto>?): List<Category> {
        return dto!!.map {
            Category(
                id = it.id,
                name = it.name
            )
        }
    }
}