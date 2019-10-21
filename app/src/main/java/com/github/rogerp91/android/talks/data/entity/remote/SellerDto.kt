package com.github.rogerp91.android.talks.data.entity.remote

data class SellerDto(
    val id: Int,
    val power_seller_status: String?,
    val car_dealer: Boolean,
    val real_estate_agency: Boolean,
    val tags: List<String>
)