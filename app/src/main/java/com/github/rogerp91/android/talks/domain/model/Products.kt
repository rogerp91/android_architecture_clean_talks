package com.github.rogerp91.android.talks.domain.model

/**
 * Created by rpatino on oct/2019
 */
data class Products(
    val site_id: String?,
    val query: String?,
    val paging: Paging?,
    val results: List<Results?>
)