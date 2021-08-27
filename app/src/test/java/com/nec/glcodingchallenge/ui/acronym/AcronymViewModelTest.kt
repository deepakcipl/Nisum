package com.nec.glcodingchallenge.ui.acronym

import com.google.common.truth.Truth
import com.mutualmobile.gl.repo.AcronymRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class AcronymViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("acronym")

    private lateinit var acronymViewModel: AcronymViewModel
    private val acronymRepo = Mockito.mock(AcronymRepo::class.java)


    @Before
    fun setUp() {

        acronymViewModel = AcronymViewModel()
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun getAcronymRepo() {
        val result = acronymRepo
        Truth.assertThat(result)
    }

    @Test
    fun setAcronymRepo() {

        val result = acronymRepo
        Truth.assertThat(result)
    }

    @Test
    fun getDataAcronym() {

        val result = acronymViewModel.dataAcronym
        Truth.assertThat(result)
    }

    @Test
    fun setDataAcronym() {

        val result = acronymViewModel.dataAcronym
        Truth.assertThat(result)
    }

    @Test
    fun getDataLoading() {

        val result = acronymViewModel.dataLoading
        Truth.assertThat(result)
    }

    @Test
    fun setDataLoading() {

        val result = acronymViewModel.dataLoading
        Truth.assertThat(result)
    }

}