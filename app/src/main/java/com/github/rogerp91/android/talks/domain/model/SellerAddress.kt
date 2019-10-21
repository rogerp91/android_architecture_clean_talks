package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class SellerAddress(
    val id: String?,
    val comment: String?,
    val address_line: String?,
    val zip_code: String?,
    val country: Country?,
    val state: State?,
    val city: City?,
    val latitude: String?,
    val longitude: String?
)