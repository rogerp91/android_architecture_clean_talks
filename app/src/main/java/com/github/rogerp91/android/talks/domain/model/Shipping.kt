package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class Shipping(
    val free_shipping: Boolean?,
    val mode: String?,
    val tags: List<String>?,
    val logistic_type: String?,
    val store_pick_up: Boolean?
)