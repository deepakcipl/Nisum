package com.nec.glcodingchallenge.injection.module

import com.nec.glcodingchallenge.injection.scope.ActivityScope
import com.nec.glcodingchallenge.ui.acronym.AcronymActivity
import com.nec.glcodingchallenge.ui.acronym.AcronymActivityModule
import com.nec.glcodingchallenge.ui.home.HomeActivity
import com.nec.glcodingchallenge.ui.home.HomeActivityModule
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

/**
 * To create dependencies for a specific activity, don't extend the required activity module with #ActivityModule, instead create a plain module and include #BaseActivityModule in the annotation.
 */
@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = [HomeActivityModule::class])

  internal abstract fun bindHomeActivity(): HomeActivity

  @ActivityScope
  @ContributesAndroidInjector(
    modules = [AcronymActivityModule::class])

  internal abstract fun bindAcronymActivity(): AcronymActivity



}

@Module(includes = [BaseActivityModule::class])
abstract class ActivityModule<in T : DaggerAppCompatActivity> {
  @Binds
  @ActivityScope
  internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
  @ActivityScope
  @Provides internal fun provideRxPermissions(activity: DaggerAppCompatActivity) = RxPermissions(
      activity
  )
}