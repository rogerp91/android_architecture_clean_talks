package com.github.rogerp91.android.talks.presentation.internal.di.component

import android.app.Application
import com.github.rogerp91.android.talks.App
import com.github.rogerp91.android.talks.presentation.internal.di.builder.ContextModule
import com.github.rogerp91.android.talks.presentation.internal.di.module.ActivityBindingModule
import com.github.rogerp91.android.talks.presentation.internal.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rpatino on oct/2019
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class, ContextModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}