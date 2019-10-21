package com.github.rogerp91.android.talks.domain.usecase

import com.github.rogerp91.android.talks.domain.repository.CategoryRepository
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class UpdateCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) : BaseUseCase<Unit>() {

    override suspend fun executeOnBackground() {
        return categoryRepository.refreshCategories()
    }
}