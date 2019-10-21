package com.github.rogerp91.android.talks.data.entity.remote

data class ProductsDto(
    val site_id: String,
    val query: String,
    val paging: PagingDto,
    val results: List<ResultsDto>
)