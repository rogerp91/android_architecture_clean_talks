package com.github.rogerp91.android.talks.data.entity.remote

data class ShippingDto(
    val free_shipping: Boolean,
    val mode: String,
    val tags: List<String>,
    val logistic_type: String,
    val store_pick_up: Boolean
)