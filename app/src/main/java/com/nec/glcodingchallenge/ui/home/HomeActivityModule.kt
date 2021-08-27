package com.nec.glcodingchallenge.ui.home

import android.content.Context
import com.nec.glcodingchallenge.injection.module.BaseActivityModule
import com.nec.glcodingchallenge.injection.qualifiers.ActivityContext
import com.nec.glcodingchallenge.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class HomeActivityModule {

    @Binds
    @ActivityContext
    abstract fun provideActivityContext(activity: HomeActivity): Context

    @Binds
    @ActivityScope
    abstract fun provideActivity(homeActivity: HomeActivity): DaggerAppCompatActivity
}