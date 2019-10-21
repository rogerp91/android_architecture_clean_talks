package com.github.rogerp91.android.talks.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by rpatino on oct/2019
 */
@Parcelize
data class SellerModel(
    val power_seller_status: String?,
    val car_dealer: Boolean?,
    val real_estate_agency: Boolean?,
    val tags: List<String>?
) : Parcelable