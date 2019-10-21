package com.github.rogerp91.android.talks.presentation.provider

import android.content.SearchRecentSuggestionsProvider

/**
 * Created by rpatino on oct/2019
 */
class SearchContentProvider : SearchRecentSuggestionsProvider() {

    init {
        setupSuggestions(AUTHORITY, MODE)
    }

    companion object {
        const val AUTHORITY =
            "com.github.rogerp91.android.talks.presentation.provider.SearchContentProvider"
        const val MODE: Int = DATABASE_MODE_QUERIES or DATABASE_MODE_2LINES
    }
}