package com.github.rogerp91.android.talks.presentation.internal.di.module

import com.github.rogerp91.android.talks.presentation.fragment.ProductDetailFragment
import com.github.rogerp91.android.talks.presentation.internal.di.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rpatino on oct/2019
 */
@Module
abstract class SearchableActivityBindFragmentModule {
    @ContributesAndroidInjector(modules = [ProductDetailFragmentModule::class])

    @PerFragment
    abstract fun productDetailFragment(): ProductDetailFragment
}