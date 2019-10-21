package com.github.rogerp91.android.talks.data.entity.remote

data class ResultsDto(
    val id: String?,
    val site_id: String?,
    val title: String?,
    val seller: SellerDto?,
    val price: Float?,
    val currency_id: String?,
    val available_quantity: Int?,
    val sold_quantity: Int?,
    val buying_mode: String?,
    val listing_type_id: String?,
    val stop_time: String?,
    val condition: String?,
    val permalink: String?,
    val thumbnail: String?,
    val accepts_mercadopago: Boolean?,
    val installmentsDto: InstallmentsDto?,
    val addressDto: AddressDto?,
    val shippingDto: ShippingDto?,
    val seller_addressDto: SellerAddressDto?,
    val attributes: List<AttributesDto>?,
    val differential_pricingDto: DifferentialPricingDto?,
    val original_price: Float?,
    val category_id: String?,
    val official_store_id: String,
    val catalog_product_id: String?,
    val tags: List<String>?,
    val catalog_listing: Boolean?
)