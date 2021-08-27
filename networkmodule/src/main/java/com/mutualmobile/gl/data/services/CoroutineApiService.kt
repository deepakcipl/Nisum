package com.mutualmobile.gl.data.services

import com.mutualmobile.gl.data.model.news.acronym.Json4KotlinAcronymBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoroutineApiService {

    @GET("software/acromine/dictionary.py")
    suspend fun getDictionary( @Query("sf") sf: String): Response<List<Json4KotlinAcronymBase>>
}