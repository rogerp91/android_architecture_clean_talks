package com.github.rogerp91.android.talks.domain.usecase

import com.github.rogerp91.android.talks.domain.model.Products
import com.github.rogerp91.android.talks.domain.repository.GetProductsByKeyword
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class SearchProducts @Inject constructor(
    private val getProductByKeyWord: GetProductsByKeyword
) : BaseUseCase<Products>() {

    private lateinit var keyWord: String

    override suspend fun executeOnBackground(): Products {
        return getProductByKeyWord.getProductsByKeyword(keyWord)
    }

    fun setKeyWord(keyWord: String) {
        this.keyWord = keyWord
    }
}