package com.github.rogerp91.android.talks.presentation.activity

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.android.talks.R
import com.github.rogerp91.android.talks.presentation.fragment.ProductDetailFragment
import com.github.rogerp91.android.talks.presentation.model.ProductModel
import com.github.rogerp91.android.talks.presentation.provider.SearchContentProvider
import com.github.rogerp91.android.talks.presentation.viewmodel.SearchViewModel
import com.github.rogerp91.android.talks.presentation.adapter.SearchProductsAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class SearchableActivity : DaggerAppCompatActivity() {

    companion object {
        private const val BACK_STACK_ROOT_TAG = "back_stack_root"
    }

    private var RECYCLER_VISIBILITY = "recycler_visibility"
    private var recyclerVisibility: Int? = -1

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModelAdapter: SearchProductsAdapter? = null

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    private val progressBar by lazy {
        findViewById<ProgressBar>(R.id.loading_spinner)
    }

    private val productRecyclerView by lazy {
        findViewById<RecyclerView>(R.id.products_recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.talks_activity_search)

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                searchQuery(query)
            }
        }
        viewModelAdapter = SearchProductsAdapter(ProductCallback {
            productRecyclerView.visibility = View.GONE
            goToProductDetail(ProductDetailFragment.newInstance(it))
        })

        productRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        savedInstanceState?.let {
            productRecyclerView.visibility = savedInstanceState.getInt(RECYCLER_VISIBILITY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        recyclerVisibility = productRecyclerView.visibility
        with(outState) {
            putInt(RECYCLER_VISIBILITY, recyclerVisibility!!)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        productRecyclerView.visibility = View.VISIBLE
    }

    private fun searchQuery(query: String) {
        SearchRecentSuggestions(
            this,
            SearchContentProvider.AUTHORITY,
            SearchContentProvider.MODE
        ).saveRecentQuery(query, null)
        search(query)
    }

    private fun goToProductDetail(fragment: Fragment) {
        supportFragmentManager.apply {
            beginTransaction().replace(R.id.fragment_container, fragment, ProductDetailFragment.TAG)
                .addToBackStack(BACK_STACK_ROOT_TAG).commit()
        }
    }

    private fun search(query: String) {
        viewModel.setKeyWord(query)
        with(viewModel) {
            refreshListProduct()
            showError()
        }
    }

    private fun SearchViewModel.showError() {
        error.observe(this@SearchableActivity, Observer {
            progressBar.visibility = View.GONE
            Toast.makeText(applicationContext, "${it?.message}", Toast.LENGTH_LONG).show()
        })
    }

    private fun SearchViewModel.refreshListProduct() {
        productModel.observe(this@SearchableActivity, Observer { products ->
            progressBar.visibility = View.GONE
            viewModelAdapter?.productModelList = products
        })
    }
}

class ProductCallback(val block: (ProductModel) -> Unit) {

    fun onClick(product: ProductModel) = block(product)
}
