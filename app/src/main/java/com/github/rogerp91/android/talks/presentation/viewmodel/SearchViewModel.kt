package com.github.rogerp91.android.talks.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.rogerp91.android.talks.presentation.model.ErrorModel
import com.github.rogerp91.android.talks.domain.usecase.SearchProducts
import com.github.rogerp91.android.talks.presentation.model.ProductModel
import com.github.rogerp91.android.talks.presentation.model.mapper.ProductsModelMapper
import com.github.rogerp91.android.talks.presentation.viewmodel.presentation.ErrorPresentationModel
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class SearchViewModel @Inject constructor(
    private val searchProducts: SearchProducts,
    private val mapper: ProductsModelMapper,
    private val errorPresentation: ErrorPresentationModel
) : ViewModel() {
    val productModel: MutableLiveData<List<ProductModel>> by lazy { MutableLiveData<List<ProductModel>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    fun setKeyWord(query: String) {
        searchProducts.setKeyWord(query)
        searchProducts.execute {
            onComplete {
                productModel.value = mapper.transform(it.results)
            }
            onError { throwable ->
                val errorModel = errorPresentation.transform(throwable)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        searchProducts.unsubscribe()
    }
}