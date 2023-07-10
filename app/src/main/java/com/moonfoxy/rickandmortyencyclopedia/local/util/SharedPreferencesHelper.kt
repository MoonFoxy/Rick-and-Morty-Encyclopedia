package com.moonfoxy.rickandmortyencyclopedia.local.util

import android.content.Context
import android.content.SharedPreferences
import com.moonfoxy.rickandmortyencyclopedia.BuildConfig.APPLICATION_ID
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(context: Context) {
    companion object {
        private const val PREF_PACKAGE_NAME = "$APPLICATION_ID.cache.preferences"
        private const val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var lastCacheTime: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = preferences.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()
}