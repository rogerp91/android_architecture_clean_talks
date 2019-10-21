package com.github.rogerp91.android.talks.domain.model

import com.github.rogerp91.android.talks.presentation.model.CategoryModel

/**
 * Created by rpatino on oct/2019
 */
data class Category(
    val id: String, val name: String
) {

    fun toModel(): CategoryModel = CategoryModel(id, name)
}