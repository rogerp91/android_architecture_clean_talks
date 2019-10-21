package com.github.rogerp91.android.talks.domain.repository

import com.github.rogerp91.android.talks.domain.model.Products

interface GetProductsByKeyword {

    suspend fun getProductsByKeyword(keyWord: String): Products

}