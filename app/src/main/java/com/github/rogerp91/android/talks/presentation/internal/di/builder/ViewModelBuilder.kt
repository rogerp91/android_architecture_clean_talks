package com.github.rogerp91.android.talks.presentation.internal.di.builder

import androidx.lifecycle.ViewModelProvider
import com.github.rogerp91.android.talks.presentation.internal.di.builder.AppViewModelBuilder
import com.github.rogerp91.android.talks.presentation.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by rpatino on oct/2019
 */
@Module(includes = [AppViewModelBuilder::class])
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}