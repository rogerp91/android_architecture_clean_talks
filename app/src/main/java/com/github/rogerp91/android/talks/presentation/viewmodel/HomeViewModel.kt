package com.github.rogerp91.android.talks.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.rogerp91.android.talks.domain.usecase.GetCategoriesUseCase
import com.github.rogerp91.android.talks.domain.usecase.UpdateCategoriesUseCase
import com.github.rogerp91.android.talks.presentation.model.CategoryModel
import com.github.rogerp91.android.talks.presentation.model.ErrorModel
import com.github.rogerp91.android.talks.presentation.viewmodel.presentation.ErrorPresentationModel
import com.github.rogerp91.android.talks.presentation.viewmodel.presentation.ListCategoryPresentation
import javax.inject.Inject

/**
 * Created by rpatino on oct/2019
 */
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val updateCategoriesUseCase: UpdateCategoriesUseCase,
    private val errorPresentation: ErrorPresentationModel,
    private val categoryPresentation: ListCategoryPresentation
) : ViewModel() {

    val categories: MutableLiveData<List<CategoryModel>> by lazy { MutableLiveData<List<CategoryModel>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    init {
        updateCategoriesUseCase.execute {
            onComplete {
                getCategories()
            }
            onError { throwable ->
                val errorModel = errorPresentation.transform(throwable)
                error.value = errorModel
                getCategories()
            }
        }
    }

    private fun getCategories() {
        getCategoriesUseCase.execute {
            onComplete {
                categories.value = categoryPresentation.tranform()
            }
            onError { throwable ->
                val errorModel = errorPresentation.transform(throwable)
                error.value = errorModel
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getCategoriesUseCase.unsubscribe()
        updateCategoriesUseCase.unsubscribe()
    }
}