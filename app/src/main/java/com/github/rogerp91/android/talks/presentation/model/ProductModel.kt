package com.github.rogerp91.android.talks.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by rpatino on oct/2019
 */
@Parcelize
data class ProductModel(
    val title: String?,
    val seller: SellerModel?,
    val price: Float?,
    val available_quantity: Int?,
    val sold_quantity: Int?,
    val buying_mode: String?,
    val thumbnail: String?,
    val accepts_mercadopago: Boolean?
) : Parcelable