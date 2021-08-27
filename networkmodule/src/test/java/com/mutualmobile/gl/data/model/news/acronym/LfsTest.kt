package com.mutualmobile.gl.data.model.news.acronym

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
@RunWith(JUnit4::class)
class LfsTest {

    private lateinit var lfs: Lfs


    private val lfsMock = Mockito.mock(Lfs::class.java)
    private val varsMock = Mockito.mock(Vars::class.java)

    @Before
    fun setUp() {
        val lf = "By the way"
        val freq = 10
        val since = 1886
        val list = arrayListOf<Vars>()
        lfs = Lfs(lf, freq, since, list)
    }

    @Test
    fun getLf() {

        var result = lfs.lf
        Truth.assertThat(result)
    }

    @Test
    fun getFreq() {

        var result = lfs.freq
        Truth.assertThat(result)
    }

    @Test
    fun getSince() {

        var result = lfs.since
        Truth.assertThat(result)
    }

    @Test
    fun getVars() {

        var result = lfs.vars
        Truth.assertThat(result)
    }

    @Test
    fun copy() {
        val lfCopy = lfs.copy(lf = "By the way")
        Truth.assertThat(lfCopy)
    }
}