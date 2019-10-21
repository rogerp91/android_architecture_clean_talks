package com.github.rogerp91.android.talks.presentation.model.mapper

import com.github.rogerp91.android.talks.domain.model.Seller
import com.github.rogerp91.android.talks.presentation.model.SellerModel

/**
 * Created by rpatino on oct/2019
 */
class SellerUiMapper {
    fun asUiModel(seller: Seller?): SellerModel {
        return SellerModel(
            power_seller_status = seller?.power_seller_status,
            car_dealer = seller?.car_dealer,
            real_estate_agency = seller?.real_estate_agency,
            tags = seller?.tags
        )
    }
}