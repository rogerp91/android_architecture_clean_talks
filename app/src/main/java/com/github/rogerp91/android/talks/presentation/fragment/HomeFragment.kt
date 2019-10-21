package com.github.rogerp91.android.talks.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.android.talks.R
import com.github.rogerp91.android.talks.databinding.TalksFragmentHomeBinding
import com.github.rogerp91.android.talks.presentation.adapter.CategoryAdapter
import com.github.rogerp91.android.talks.presentation.viewmodel.HomeViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.talks_fragment_home.view.*
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    private var viewModelAdapter: CategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TalksFragmentHomeBinding>(
            inflater,
            R.layout.talks_fragment_home, container, false
        )

        viewModelAdapter = CategoryAdapter()

        binding.root.findViewById<RecyclerView>(R.id.category_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            refreshListProduct(view)
            showError(view)
        }
    }

    private fun HomeViewModel.showError(view: View) {
        error.observe(this@HomeFragment, Observer {
            view.loading_spinner.visibility = View.GONE
            Toast.makeText(context, "${it?.message}", Toast.LENGTH_LONG).show()
        })
    }

    private fun HomeViewModel.refreshListProduct(view: View) {
        categories.observe(this@HomeFragment, Observer { categories ->
            viewModelAdapter?.categories = categories
            view.loading_spinner.visibility = View.GONE
        })
    }
}
