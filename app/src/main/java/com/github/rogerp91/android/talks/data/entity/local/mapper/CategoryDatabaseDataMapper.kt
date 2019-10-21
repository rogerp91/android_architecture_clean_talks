package com.github.rogerp91.android.talks.data.entity.local.mapper

import com.github.rogerp91.android.talks.data.entity.local.CategoryDatabase
import com.github.rogerp91.android.talks.domain.model.Category
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.DomainDatabaseMapper
import com.github.rogerp91.lightningtalksandroid.data.entity.local.mapper.util.LocalDatabaseMapper

/**
 * Created by rpatino on oct/2019
 */
class CategoryDatabaseDataMapper :
    LocalDatabaseMapper<List<CategoryDatabase>, List<Category>>,
    DomainDatabaseMapper<List<Category>, Array<CategoryDatabase>> {

    override fun asDomainModel(database: List<CategoryDatabase>?): List<Category> {
        return database!!.map {
            Category(
                id = it.id,
                name = it.name
            )
        }
    }

    override fun asDatabaseModel(domain: List<Category>?): Array<CategoryDatabase> {
        return domain!!.map {
            CategoryDatabase(
                id = it.id,
                name = it.name
            )
        }.toTypedArray()
    }
}