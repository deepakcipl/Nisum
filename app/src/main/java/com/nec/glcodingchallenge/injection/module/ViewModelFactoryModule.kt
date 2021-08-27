package com.nec.glcodingchallenge.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nec.glcodingchallenge.injection.scope.ViewModelScope
import com.nec.glcodingchallenge.ui.acronym.AcronymViewModel
import com.nec.glcodingchallenge.ui.home.HomeViewModel
import com.nec.glcodingchallenge.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelScope(HomeViewModel::class)
  abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel


  @Binds
  @IntoMap
  @ViewModelScope(AcronymViewModel::class)
  abstract fun bindAcronymViewModel(acronymViewModel: AcronymViewModel): ViewModel


  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
