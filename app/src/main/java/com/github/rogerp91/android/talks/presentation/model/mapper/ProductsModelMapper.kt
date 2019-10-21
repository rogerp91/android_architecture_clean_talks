package com.github.rogerp91.android.talks.presentation.model.mapper

import com.github.rogerp91.android.talks.domain.model.Results
import com.github.rogerp91.android.talks.presentation.model.ProductModel
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class ProductsModelMapper @Inject constructor(
    private val sellerUiMapper: SellerUiMapper
) {
    fun transform(results: List<Results?>): List<ProductModel> {
        return results.map {
            ProductModel(
                title = it?.title,
                seller = sellerUiMapper.asUiModel(it?.seller),
                price = it?.price,
                available_quantity = it?.available_quantity,
                sold_quantity = it?.sold_quantity,
                buying_mode = it?.buying_mode,
                thumbnail = it?.thumbnail,
                accepts_mercadopago = it?.accepts_mercadopago
            )
        }
    }
}