package com.github.rogerp91.android.talks.presentation.activity

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.github.rogerp91.android.talks.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        private const val SEARCH_KEY = "search"
    }

    private lateinit var searchView: SearchView
    private lateinit var searchMenuItem: MenuItem

    private var searchString: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.talks_activity_main)
        savedInstanceState?.let {
            searchString = it.getString(SEARCH_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        searchString = searchView.query.toString()
        with(outState) {
            putString(SEARCH_KEY, searchString)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        searchMenuItem = menu.findItem(R.id.action_search)
        searchView = searchMenuItem.actionView as SearchView

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
        }

        searchString?.let {
            if (it.isNotEmpty()) {
                searchMenuItem.expandActionView()
                searchView.setQuery(searchString, false)
            }
        }
        return super.onCreateOptionsMenu(menu)
    }
}
