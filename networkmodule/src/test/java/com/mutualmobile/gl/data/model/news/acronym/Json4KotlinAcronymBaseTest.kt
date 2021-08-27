package com.mutualmobile.gl.data.model.news.acronym

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class Json4KotlinAcronymBaseTest {

    private lateinit var json4KotlinAcronymBase: Json4KotlinAcronymBase


    private val lfs = Mockito.mock(Lfs::class.java)
    private val vars = Mockito.mock(Vars::class.java)


    @Before
    fun setUp() {

        val sf = "BTW"
        val list = arrayListOf<Lfs>()
        json4KotlinAcronymBase = Json4KotlinAcronymBase(sf, list)
    }

    @Test
    fun getSf() {

        var result = json4KotlinAcronymBase.sf
        Truth.assertThat(result)
    }

    @Test
    fun getLfs() {

        var result = json4KotlinAcronymBase.lfs
        Truth.assertThat(result)
    }

    @Test
    fun copy() {

        val json4KotlinAcronymBaseCopy = json4KotlinAcronymBase.copy(sf = "BTW")
        Truth.assertThat(json4KotlinAcronymBaseCopy)
    }
}