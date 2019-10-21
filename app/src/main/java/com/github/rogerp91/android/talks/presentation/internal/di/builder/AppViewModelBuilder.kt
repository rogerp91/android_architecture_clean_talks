package com.github.rogerp91.android.talks.presentation.internal.di.builder

import androidx.lifecycle.ViewModel
import com.github.rogerp91.android.talks.presentation.internal.di.qualifier.ViewModelKey
import com.github.rogerp91.android.talks.presentation.viewmodel.HomeViewModel
import com.github.rogerp91.android.talks.presentation.viewmodel.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by rpatino on oct/2019
 */
@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}