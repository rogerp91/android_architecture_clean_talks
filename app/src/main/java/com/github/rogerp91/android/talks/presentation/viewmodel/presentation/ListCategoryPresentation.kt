package com.github.rogerp91.android.talks.presentation.viewmodel.presentation

import com.github.rogerp91.android.talks.domain.model.Category
import com.github.rogerp91.android.talks.presentation.model.CategoryModel

/**
 * Created by rpatino on oct/2019
 */
class ListCategoryPresentation(
    val listCategory: List<Category> = emptyList()
) {

    fun shouldEmptyCategory() = listCategory.isEmpty()

    fun tranform(): List<CategoryModel> {
        return listCategory.map { it.toModel() }
    }
}