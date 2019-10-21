package com.github.rogerp91.android.talks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.android.talks.R
import com.github.rogerp91.android.talks.databinding.TalksCategoryItemBinding
import com.github.rogerp91.android.talks.presentation.model.CategoryModel

/**
 * Created by rpatino on oct/2019
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    var categories: List<CategoryModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val withDataBinding: TalksCategoryItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CategoryViewHolder.LAYOUT,
            parent,
            false
        )
        return CategoryViewHolder(withDataBinding)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.category = categories[position]
        }
    }
}

class CategoryViewHolder(val viewDataBinding: TalksCategoryItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {

        @LayoutRes
        val LAYOUT = R.layout.talks_category_item
    }
}
