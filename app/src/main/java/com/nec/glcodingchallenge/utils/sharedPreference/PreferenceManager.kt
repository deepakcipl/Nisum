package com.nec.glcodingchallenge.utils.sharedPreference

import android.content.Context
import android.content.SharedPreferences

open class PreferenceManager constructor(context: Context) : IPreferenceHelper {
    private val PREFS_NAME = "SharedPreference"
    private var preferences: SharedPreferences
    init {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    override fun setApiKey(apiKey: String) {
        preferences[API_KEY] = apiKey
    }
    override fun getApiKey(): String {
        return preferences[API_KEY] ?: ""
    }
    override fun setUserId(userId: String) {
        preferences[USER_ID] = userId
    }
    override fun getUserId(): String {
        return preferences[USER_ID] ?: ""
    }
    override fun clearPrefs() {
        preferences.edit().clear().apply()
    }
    companion object {
        const val API_KEY = "api_key"
        const val USER_ID = "user_id"
    }
}