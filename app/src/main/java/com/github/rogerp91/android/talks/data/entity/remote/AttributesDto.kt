package com.github.rogerp91.android.talks.data.entity.remote

/**
 * Created by rpatino on oct/2019
 */
data class AttributesDto(
    val id: String,
    val name: String,
    val value_id: Int,
    val value_name: String,
    val attribute_group_id: String,
    val attribute_group_name: String,
    val source: Double
)