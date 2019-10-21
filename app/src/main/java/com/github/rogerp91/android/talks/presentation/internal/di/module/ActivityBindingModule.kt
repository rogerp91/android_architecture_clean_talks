package com.github.rogerp91.android.talks.presentation.internal.di.module

import com.github.rogerp91.android.talks.presentation.activity.MainActivity
import com.github.rogerp91.android.talks.presentation.activity.SearchableActivity
import com.github.rogerp91.android.talks.presentation.internal.di.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rpatino on oct/2019
 */
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainActivityBindFragmentModule::class])
    @PerActivity
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SearchableActivityBindFragmentModule::class])
    @PerActivity
    abstract fun searChableActivity(): SearchableActivity
}