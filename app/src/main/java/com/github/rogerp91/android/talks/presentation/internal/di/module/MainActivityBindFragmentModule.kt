package com.github.rogerp91.android.talks.presentation.internal.di.module

import com.github.rogerp91.android.talks.presentation.fragment.HomeFragment
import com.github.rogerp91.android.talks.presentation.internal.di.PerFragment
import com.github.rogerp91.lightningtalksandroid.view.internal.di.module.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rpatino on oct/2019
 */
@Module
abstract class MainActivityBindFragmentModule {
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @PerFragment
    abstract fun homeFragment(): HomeFragment
}