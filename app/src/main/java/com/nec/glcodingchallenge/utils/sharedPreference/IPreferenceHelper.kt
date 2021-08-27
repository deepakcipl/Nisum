package com.nec.glcodingchallenge.utils.sharedPreference

interface IPreferenceHelper {
    fun setApiKey(apiKey: String)
    fun getApiKey(): String
    fun setUserId(userId: String)
    fun getUserId(): String
    fun clearPrefs()
}