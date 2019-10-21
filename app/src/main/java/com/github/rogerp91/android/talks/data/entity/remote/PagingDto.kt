package com.github.rogerp91.android.talks.data.entity.remote

data class PagingDto(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primary_results: Int
)