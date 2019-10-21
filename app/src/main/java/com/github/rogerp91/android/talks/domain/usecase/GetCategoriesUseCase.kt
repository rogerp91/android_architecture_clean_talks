package com.github.rogerp91.android.talks.domain.usecase

import com.github.rogerp91.android.talks.domain.model.Category
import com.github.rogerp91.android.talks.domain.repository.CategoryRepository
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) : BaseUseCase<List<Category>>() {

    override suspend fun executeOnBackground(): List<Category> {
        return categoryRepository.getCategories()
    }
}