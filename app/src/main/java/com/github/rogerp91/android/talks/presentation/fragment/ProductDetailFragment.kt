package com.github.rogerp91.android.talks.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.rogerp91.android.talks.R
import com.github.rogerp91.android.talks.databinding.TalksFragmentProductDetailBinding
import com.github.rogerp91.android.talks.presentation.model.ProductModel
import dagger.android.support.DaggerFragment

/**
 * Created by rpatino on oct/2019
 */
class ProductDetailFragment : DaggerFragment() {

    companion object {
        val TAG = ProductDetailFragment::class.java.simpleName

        private const val EXTRA_PRODUCT_UI =
            "com.github.rogerp91.android.talks.presentation.model.ProductUi"

        fun newInstance(product: ProductModel): ProductDetailFragment {
            val fragment = ProductDetailFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(EXTRA_PRODUCT_UI, product)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TalksFragmentProductDetailBinding>(
            inflater,
            R.layout.talks_fragment_product_detail, container, false
        )
        binding.also {
            it.product = arguments?.getParcelable(EXTRA_PRODUCT_UI)
        }
        return binding.root
    }
}
