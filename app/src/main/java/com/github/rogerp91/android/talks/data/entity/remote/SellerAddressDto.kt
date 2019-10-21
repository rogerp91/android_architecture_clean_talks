package com.github.rogerp91.android.talks.data.entity.remote

data class SellerAddressDto(
    val id: String?,
    val comment: String?,
    val address_line: String?,
    val zip_code: String?,
    val countryDto: CountryDto?,
    val stateDto: StateDto?,
    val cityEntity: CityDto?,
    val latitude: String?,
    val longitude: String?
)