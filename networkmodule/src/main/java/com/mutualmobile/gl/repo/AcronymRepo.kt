package com.mutualmobile.gl.repo

import com.mutualmobile.gl.data.model.news.acronym.Json4KotlinAcronymBase
import com.mutualmobile.gl.NetworkResult
import com.mutualmobile.gl.data.services.CoroutineApiService

class AcronymRepo constructor(private val coroutineApiService: CoroutineApiService) {

    suspend fun getDictionary(name: String): NetworkResult<List<Json4KotlinAcronymBase>> {
        val response = coroutineApiService.getDictionary(name)
        if (response.isSuccessful) {
            val data = response.body()
            if (data != null) {
                return NetworkResult.Success(data)
            }
        }
        return NetworkResult.Failure(response)
    }
}