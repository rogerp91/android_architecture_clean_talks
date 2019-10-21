package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class Installments(
    val quantity: Int?,
    val amount: Double?,
    val rate: Int?,
    val currency_id: String?
)