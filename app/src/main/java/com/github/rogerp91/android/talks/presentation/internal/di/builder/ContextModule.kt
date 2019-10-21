package com.github.rogerp91.android.talks.presentation.internal.di.builder

import android.app.Application
import android.content.Context
import com.github.rogerp91.android.talks.presentation.internal.di.builder.ViewModelBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rpatino on oct/2019
 */
@Module(includes = [ViewModelBuilder::class])
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}