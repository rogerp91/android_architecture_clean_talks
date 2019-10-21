package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primary_results: Int
)