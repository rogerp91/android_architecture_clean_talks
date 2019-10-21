package com.github.rogerp91.android.talks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.android.talks.R
import com.github.rogerp91.android.talks.databinding.TalksProductsItemBinding
import com.github.rogerp91.android.talks.presentation.activity.ProductCallback
import com.github.rogerp91.android.talks.presentation.model.ProductModel

/**
 * Created by rpatino on oct/2019
 */
class SearchProductsAdapter(
    private val callback: ProductCallback
) : RecyclerView.Adapter<ProductsViewHolder>() {

    var productModelList: List<ProductModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val withDataBinding: TalksProductsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ProductsViewHolder.LAYOUT,
            parent,
            false
        )
        return ProductsViewHolder(withDataBinding)
    }

    override fun getItemCount() = productModelList.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.product = productModelList[position]
            it.productCallback = callback
        }
    }
}

class ProductsViewHolder(val viewDataBinding: TalksProductsItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.talks_products_item
    }
}