package com.mutualmobile.gl.data.model.news.acronym

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class VarsTest {

    private lateinit var vars: Vars


    private val lfsMock = Mockito.mock(Lfs::class.java)
    private val varsMock = Mockito.mock(Vars::class.java)


    @Before
    fun setUp() {

        val lf = "By the way"
        val freq = 10
        val since = 1886
        vars = Vars(lf, freq, since)
    }

    @Test
    fun getLf() {

        var result = vars.lf
        Truth.assertThat(result)
    }

    @Test
    fun getFreq() {

        var result = vars.freq
        Truth.assertThat(result)
    }

    @Test
    fun getSince() {

        var result = vars.since
        Truth.assertThat(result)
    }

    @Test
    fun copy() {
        val varsCopy = vars.copy(lf = "By the way")
        Truth.assertThat(varsCopy)
    }
}