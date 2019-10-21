package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class Seller(
    val id: Int?,
    val power_seller_status: String?,
    val car_dealer: Boolean?,
    val real_estate_agency: Boolean?,
    val tags: List<String>?
)