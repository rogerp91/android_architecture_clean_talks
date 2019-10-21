package com.github.rogerp91.android.talks.data.entity.remote

data class InstallmentsDto(
    val quantity: Int,
    val amount: Double,
    val rate: Int,
    val currency_id: String
)