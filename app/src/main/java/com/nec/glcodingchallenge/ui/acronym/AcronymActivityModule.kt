package com.nec.glcodingchallenge.ui.acronym

import android.content.Context
import com.nec.glcodingchallenge.injection.module.BaseActivityModule
import com.nec.glcodingchallenge.injection.qualifiers.ActivityContext
import com.nec.glcodingchallenge.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class AcronymActivityModule {
    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: AcronymActivity): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(activity: AcronymActivity): DaggerAppCompatActivity
}