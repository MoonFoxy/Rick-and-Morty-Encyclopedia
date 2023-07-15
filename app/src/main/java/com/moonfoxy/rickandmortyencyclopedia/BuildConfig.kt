package com.moonfoxy.rickandmortyencyclopedia

internal object BuildConfig {
    const val DEBUG: Boolean = true
    const val APPLICATION_ID: String = "com.moonfoxy.rickandmortyencyclopedia"
    const val BUILD_TYPE: String = "beta"

    const val BASE_URL: String = "https://rickandmortyapi.com/api/"
    const val OK_HTTP_TIMEOUT = 60L

    /**
     * Set the cache expiration time to 5 minutes
     */
    const val CACHE_EXPIRATION_TIME = (60 * 5 * 1000).toLong()

    const val CHARACTERS_IN_PAGE = 20
}