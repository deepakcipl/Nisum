package com.nec.glcodingchallenge.ui.acronym

import com.mutualmobile.gl.data.model.news.acronym.Json4KotlinAcronymBase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mutualmobile.gl.NetworkResult
import com.mutualmobile.gl.repo.AcronymRepo
import com.nec.glcodingchallenge.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class AcronymViewModel @Inject constructor() : BaseViewModel() {
    @Inject
    lateinit var acronymRepo: AcronymRepo
    var dataAcronym: MutableLiveData<List<Json4KotlinAcronymBase>> = MutableLiveData()
    var dataLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun loadAcronymCoroutine(acronym: String) {
        dataLoading.value = true
        viewModelScope.launch {

            when (val acronymListResult = acronymRepo.getDictionary(acronym)) {
                is NetworkResult.Success -> {
                    dataLoading.value = false
                    dataAcronym.value = acronymListResult.body
                }
                is NetworkResult.Failure -> {
                    Timber.e("onError")
                }
            }
        }

    }
}