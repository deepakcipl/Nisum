package com.nec.glcodingchallenge.injection.module

import android.app.Application
import android.content.Context
import com.nec.glcodingchallenge.utils.IRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton internal fun provideRxSchedulers(): IRxSchedulers {
    return object : IRxSchedulers {
      override fun main() = AndroidSchedulers.mainThread()
      override fun io() = Schedulers.io()
    }
  }

  @Provides
  @Singleton
  fun providesContext(app: Application): Context = app
}

