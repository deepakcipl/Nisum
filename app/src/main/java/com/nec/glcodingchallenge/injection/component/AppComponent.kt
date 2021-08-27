package com.nec.glcodingchallenge.injection.component

import android.content.Context
import com.nec.glcodingchallenge.BaseApplication
import com.nec.glcodingchallenge.injection.module.ActivityBindingModule
import com.nec.glcodingchallenge.injection.module.AppModule
import com.nec.glcodingchallenge.injection.module.NetworkModule
import com.nec.glcodingchallenge.injection.module.PreferenceModule
import com.nec.glcodingchallenge.injection.module.ViewModelFactoryModule
import com.nec.glcodingchallenge.injection.qualifiers.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelFactoryModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class, NetworkModule::class, PreferenceModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<BaseApplication>() {
    @BindsInstance
    abstract fun appContext(@ApplicationContext context: Context)

    override fun seedInstance(instance: BaseApplication?) {
      appContext(instance!!.applicationContext)
    }
  }
}
