package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */

data class Results(
    val id: String?,
    val site_id: String?,
    val title: String?,
    val seller: Seller?,
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
    val installments: Installments?,
    val address: Address?,
    val shipping: Shipping?,
    val seller_address: SellerAddress?,
    val attributes: List<Attributes>?,
    val differential_pricing: DifferentialPricing?,
    val original_price: Float?,
    val category_id: String?,
    val official_store_id: String?,
    val catalog_product_id: String?,
    val tags: List<String>?,
    val catalog_listing: Boolean?
)